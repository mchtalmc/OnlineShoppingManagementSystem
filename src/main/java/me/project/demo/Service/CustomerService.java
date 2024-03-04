package me.project.demo.Service;

import lombok.RequiredArgsConstructor;
import me.project.demo.Entity.Customer;
import me.project.demo.Repository.CustomerReposityory;
import me.project.demo.Service.validator.UniquePropertyValidator;
import me.project.demo.payload.mapper.CustomerMapper;
import me.project.demo.payload.request.CustomerRequest;
import me.project.demo.payload.response.CustomerResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerReposityory customerReposityory;
    private final UniquePropertyValidator uniquePropertyValidator;
    private final CustomerMapper customerMapper;

    public ResponseEntity<CustomerResponse> saveCustomer(CustomerRequest customerRequest) {
        //Email ve phone unique mi ? // customer ve seller servise gidip check etmem gerekiyor.
       uniquePropertyValidator.validateUnique(customerRequest.getEmail(), customerRequest.getPhoneNumber());
       //DTO=POJO
        Customer customer=  customerMapper.mapCustomerRequestToCustomer(customerRequest);
        //role
        //sifreencode
        Customer saveCustomer = customerReposityory.save(customer);
        return ResponseEntity.ok(customerMapper.mapCustomerToCustomerRespnse(saveCustomer));
    }
}
