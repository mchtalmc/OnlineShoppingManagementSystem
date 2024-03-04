package me.project.demo.payload.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import me.project.demo.Entity.Adress;
import me.project.demo.Entity.Order;
import me.project.demo.Entity.UserRole;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class CustomerResponse {
    private Long customerId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private List<Adress> adressList;
    private String email;
    private List<Order> orders;
}
