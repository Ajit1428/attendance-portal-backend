package com.apd.userservice.domain.port;

import com.apd.userservice.domain.dto.UserDTO;

import java.util.List;
import java.util.UUID;

public interface UserPort {
    List<UserDTO> fetchAllUsers();

    UserDTO registerUser(UserDTO userDTO);

    UserDTO getUserByEmail(String email);

    UserDTO fetchUserById(UUID userId);
}
