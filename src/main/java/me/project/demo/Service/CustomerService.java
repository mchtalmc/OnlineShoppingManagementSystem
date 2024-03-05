package me.project.demo.Service;

import lombok.RequiredArgsConstructor;
import me.project.demo.Entity.Customer;
import me.project.demo.Exception.ResourceNotFoundException;
import me.project.demo.Repository.CustomerReposityory;
import me.project.demo.Service.validator.UniquePropertyValidator;
import me.project.demo.payload.mapper.CustomerMapper;
import me.project.demo.payload.messages.ErrorMessages;
import me.project.demo.payload.request.CustomerRequest;
import me.project.demo.payload.response.CustomerResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static me.project.demo.payload.messages.ErrorMessages.USER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerReposityory customerReposityory;
    private final UniquePropertyValidator uniquePropertyValidator;
    private final CustomerMapper customerMapper;

    //Save Customer
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

    //GetById
    public ResponseEntity<CustomerResponse> getCustomerById(Long customerId) {
       Customer customer= customerReposityory.findById(customerId).orElseThrow(()->
                new ResourceNotFoundException(String.format(USER_NOT_FOUND, customerId)));
       return ResponseEntity.ok(customerMapper.mapCustomerToCustomerRespnse(customer));

    }
}
