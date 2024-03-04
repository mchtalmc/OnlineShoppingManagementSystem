package me.project.demo.Service.validator;

import lombok.RequiredArgsConstructor;
import me.project.demo.Exception.ConflictException;
import me.project.demo.Repository.CustomerReposityory;
import me.project.demo.Repository.SellerRepostiyory;
import me.project.demo.Service.CustomerService;
import me.project.demo.Service.SellerService;
import me.project.demo.payload.messages.ErrorMessages;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UniquePropertyValidator {

    private CustomerReposityory customerRepository;
    private SellerRepostiyory sellerRepository;


    public boolean validateUnique(String email, String phoneNumber) {
        // E-posta ve telefon numaralarının benzersiz olup olmadığını kontrol ediyoruz
        if (!isEmailUnique(email) && !isPhoneNumberUnique(phoneNumber)) {
            return true; // Eğer her ikisi de benzersizse true döndür
        } else if (!isEmailUnique(email) || !isPhoneNumberUnique(phoneNumber)) {
            return false; // Eğer e-posta veya telefon numarası zaten mevcutsa false döndür
        }
        return true; // Eğer herhangi bir e-posta veya telefon numarası mevcut değilse true döndür
    }


    private boolean isEmailUnique(String email) {
        // E-postanın hem müşteri hem de satıcı kayıtlarında benzersiz olup olmadığını kontrol ediyoruz
        return customerRepository.findByEmail(email) == null && sellerRepository.findByEmail(email) == null;
    }

    private boolean isPhoneNumberUnique(String phoneNumber) {
        // Telefon numarasının hem müşteri hem de satıcı kayıtlarında benzersiz olup olmadığını kontrol ediyoruz
        return customerRepository.findByPhoneNumber(phoneNumber) == null && sellerRepository.findByPhoneNumber(phoneNumber) == null;
    }


}
