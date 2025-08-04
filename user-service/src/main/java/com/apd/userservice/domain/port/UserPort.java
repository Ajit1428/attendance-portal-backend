package com.apd.userservice.domain.port;

import com.apd.userservice.domain.dto.UserDTO;

import java.util.List;

public interface UserPort {
    List<UserDTO> fetchAllUsers();

    UserDTO registerUser(UserDTO userDTO);

}
