package me.project.demo.Repository;

import me.project.demo.Entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepostiyory extends JpaRepository<Seller, Long> {
    Object findByPhoneNumber(String phoneNumber);

    Object findByEmail(String email);
}
