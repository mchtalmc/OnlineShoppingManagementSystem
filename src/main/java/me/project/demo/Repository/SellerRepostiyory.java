package me.project.demo.Repository;

import me.project.demo.Entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepostiyory extends JpaRepository<Seller, Long> {

    boolean existsByPhoneNumber(String phoneNumber);

    boolean existsByEmail(String email);
}
