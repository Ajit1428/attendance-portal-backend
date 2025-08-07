package com.apd.userservice.usecase.validation;

import com.apd.userservice.domain.dto.UserDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
public class UserValidation {
    public void userRegisterRequestValidation(UserDTO userDTO){
        if(userDTO.getName() == null || userDTO.getName().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }

        if(userDTO.getEmail() == null || userDTO.getEmail().isEmpty()){
            throw new IllegalArgumentException("Email cannot be empty");
        }

        if(userDTO.getPassword() == null || userDTO.getPassword().isEmpty()){
            throw new IllegalArgumentException("Password cannot be empty");
        }

        if(userDTO.getPhoneNumber() == null || userDTO.getPhoneNumber().isEmpty()){
            throw new IllegalArgumentException("Phone number cannot be empty");
        }

        if(userDTO.getDateOfBirth() == null || userDTO.getDateOfBirth() <= 0){
            throw new IllegalArgumentException("Date of birth cannot be empty");
        }
    }

    public void userLoginRequestValidation(String email, String password){
        if(email == null || email.isEmpty()){
            throw new IllegalArgumentException("Email is required to login");
        }

        if(password == null || password.isEmpty()){
            throw new IllegalArgumentException("Password is required to login");
        }

    }
}
