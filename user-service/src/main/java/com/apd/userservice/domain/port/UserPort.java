package com.apd.userservice.domain.port;

import com.apd.userservice.domain.dto.UserDTO;

public interface UserPort {
    UserDTO registerUser(String name);

    UserDTO update(UserDTO userDTO);
}
