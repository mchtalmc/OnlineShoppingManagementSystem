package me.project.demo.payload.mapper;

import me.project.demo.Entity.Customer;
import me.project.demo.payload.request.CustomerRequest;
import me.project.demo.payload.response.CustomerResponse;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {


    //DTO-POJO


    public Customer mapCustomerRequestToCustomer(CustomerRequest customerRequest){
        return Customer.builder()
                .firstName(customerRequest.getFirstName())
                .lastName(customerRequest.getLastName())
                .email(customerRequest.getEmail())
                .password(customerRequest.getPassword())
                .adressList(customerRequest.getAdressList())
                .phoneNumber(customerRequest.getPhoneNumber())
                .build();
    }

    //POJO -- DTO

    public CustomerResponse mapCustomerToCustomerRespnse(Customer customer){
        return CustomerResponse.builder()
                .customerId(customer.getCustomerId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .phoneNumber(customer.getPhoneNumber())
                .adressList(customer.getAdressList())
                .build();

    }


}
