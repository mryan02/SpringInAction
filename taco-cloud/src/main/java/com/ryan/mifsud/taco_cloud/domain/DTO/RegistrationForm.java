package com.ryan.mifsud.taco_cloud.domain.DTO;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.ryan.mifsud.taco_cloud.infrastructure.User;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegistrationForm {
    private String username;
    private String password;
    private String fullname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phonenumber;
 
    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(username, passwordEncoder.encode(password), fullname, street, city, state, zip, phonenumber);
    }
}
