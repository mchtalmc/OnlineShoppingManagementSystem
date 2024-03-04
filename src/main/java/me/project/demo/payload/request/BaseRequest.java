package me.project.demo.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import me.project.demo.Entity.Adress;

import java.util.List;
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public  abstract class BaseRequest {
    @NotNull(message = "Please enter your Firstname")
    @Size(min=4,max=16, message="Your Firstname should be at least 4 chars")
    @Pattern(regexp = "\\A(?!\\s*\\Z).+", message = "Your Firstname must consist of the characters .")
    private String firstName;

    @NotNull(message = "Please enter your surname")
    @Size(min=4,max=16, message="Your surname should be at least 4 chars")
    @Pattern(regexp = "\\A(?!\\s*\\Z).+", message = "Your surname must consist of the characters .")
    private String lastName;

    @NotNull(message = "Please enter your phoneNumber")
    @Size(min=12,max=12, message="Your phoneNumber should be 12 chars long")
    @Pattern(regexp = "\\A(?!\\s*\\Z).+", message = "Your phoneNumber must consist of the characters .")
    private String phoneNumber;


    private List<Adress> adressList;

    @Email(message = "Enter a valid email address")
    @NotNull(message = "Email address cannot be null")
    private String email;

    @NotNull(message = "Please enter your password")
    @Size(min=8,max=60, message="Your password should be at least 8 chars")
    private String password;
}
