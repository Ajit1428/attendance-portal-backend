package com.apd.userservice.usecase.user;

import com.apd.userservice.domain.dto.UserDTO;
import com.nimbusds.jose.JOSEException;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface UserUseCase {
    Map<String, String> userLogin(String email, String password) throws JOSEException;

    List<UserDTO> getAllUsers();

    UserDTO registerUser(UserDTO userDTO);

    UserDTO getUserById(UUID userId);
}
