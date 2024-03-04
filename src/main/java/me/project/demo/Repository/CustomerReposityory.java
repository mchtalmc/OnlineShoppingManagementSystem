package me.project.demo.Repository;

import me.project.demo.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerReposityory extends JpaRepository<Customer, Long> {
    Object findByPhoneNumber(String phoneNumber);

    Object findByEmail(String email);
}
