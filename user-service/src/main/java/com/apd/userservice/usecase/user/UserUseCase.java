package com.apd.userservice.usecase.user;

import com.apd.userservice.domain.dto.UserDTO;

public interface UserUseCase {
    UserDTO registerUser(String name);
}
