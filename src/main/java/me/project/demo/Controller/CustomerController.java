package me.project.demo.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.project.demo.Entity.Customer;
import me.project.demo.Service.CustomerService;
import me.project.demo.payload.request.CustomerRequest;
import me.project.demo.payload.response.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    @Autowired
    private final CustomerService customerService;

    @PostMapping("/saveCustomers")
    public ResponseEntity<CustomerResponse> saveCustomers (@Valid @RequestBody CustomerRequest customerRequest){

        return customerService.saveCustomer(customerRequest);
    }


    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable Long customerId){

        return customerService.getCustomerById(customerId);
    }

    @PutMapping("/updateCustomer/{id}")
    public ResponseEntity<CustomerResponse> updateCustomer(@PathVariable Long id,
                                                   CustomerRequest customerRequest){
        return customerService.updateCustomerById(id,customerRequest);
    }




}
