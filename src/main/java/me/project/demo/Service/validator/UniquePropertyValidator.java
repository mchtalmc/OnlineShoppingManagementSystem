package me.project.demo.Service.validator;

import lombok.RequiredArgsConstructor;
import me.project.demo.Entity.Customer;
import me.project.demo.Exception.ConflictException;
import me.project.demo.Repository.CustomerReposityory;
import me.project.demo.Repository.SellerRepostiyory;
import me.project.demo.Service.CustomerService;
import me.project.demo.Service.SellerService;
import me.project.demo.payload.messages.ErrorMessages;
import me.project.demo.payload.request.CustomerRequest;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UniquePropertyValidator {

    private CustomerReposityory customerRepository;
    private SellerRepostiyory sellerRepository;


    public void checkDuplicate(String email, String phoneNumber) {
        if (!email.isEmpty() && (customerRepository.existsByEmail(email) || sellerRepository.existsByEmail(email))) {
            throw new ConflictException(ErrorMessages.EMAIL_ALREADY_EXIST);
        }

        if (!phoneNumber.isEmpty() && (customerRepository.existsByPhoneNumber(phoneNumber) || sellerRepository.existsByPhoneNumber(phoneNumber))) {
            throw new ConflictException(ErrorMessages.PHONENUMBER_ALREADY_EXIST);
        }
    }


    public void checkUniqueProperty(Customer customer, CustomerRequest customerRequest){
        String email = "";
        String phoneNumber = "";

        if (!customer.getEmail().equalsIgnoreCase(customerRequest.getEmail())) {
            email = customerRequest.getEmail();
        }

        if (!customer.getPhoneNumber().equals(customerRequest.getPhoneNumber())) {
            phoneNumber = customerRequest.getPhoneNumber();
        }

        checkDuplicate(email, phoneNumber);
    }


}
