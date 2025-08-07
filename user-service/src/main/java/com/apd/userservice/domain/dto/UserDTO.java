package com.apd.userservice.domain.dto;

import com.apd.userservice.common.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
public class UserDTO {
    private UUID id;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private Gender gender;
    private Long dateOfBirth;
    private Long joinedDate;
    private Long updatedAt;
    private String profileUrl;
    private String accessToken;
}
