package com.apd.userservice.usecase.user;

import com.apd.userservice.domain.dto.UserDTO;

import java.util.List;

public interface UserUseCase {
    List<UserDTO> getAllUsers();

    UserDTO registerUser(UserDTO userDTO);
}
