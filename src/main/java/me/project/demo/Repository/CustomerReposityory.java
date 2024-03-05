package me.project.demo.Repository;

import me.project.demo.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerReposityory extends JpaRepository<Customer, Long> {

    boolean existsByPhoneNumber(String phoneNumber);

    boolean existsByEmail(String email);
}
