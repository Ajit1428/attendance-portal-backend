package com.apd.userservice.domain.dto;


import lombok.Data;

@Data
public class UserLoginRequestDTO {
    private String email;
    private String password;
}
