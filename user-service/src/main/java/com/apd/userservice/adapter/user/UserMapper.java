package com.apd.userservice.adapter.user;

import com.apd.userservice.domain.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
class UserMapper {
    UserEntity toEntity(UserDTO userDTO) {
        return UserEntity.builder()
                .id(UUID.randomUUID())
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .address(userDTO.getAddress())
                .dateOfBirth(userDTO.getDateOfBirth())
                .password(userDTO.getPassword())
                .phoneNumber(userDTO.getPhoneNumber())
                .gender(userDTO.getGender())
                .joinedDate(System.currentTimeMillis())
                .updatedAt(System.currentTimeMillis())
                .profileUrl(userDTO.getProfileUrl())
                .build();
    }

    UserDTO toUserDTO(UserEntity userEntity) {
        return UserDTO.builder()
                .id(UUID.randomUUID())
                .name(userEntity.getName())
                .email(userEntity.getEmail())
                .address(userEntity.getAddress())
                .dateOfBirth(userEntity.getDateOfBirth())
                .phoneNumber(userEntity.getPhoneNumber())
                .gender(userEntity.getGender())
                .joinedDate(userEntity.getJoinedDate())
                .profileUrl(userEntity.getProfileUrl())
                .build();
    }
}
