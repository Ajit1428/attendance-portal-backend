package com.apd.userservice.usecase.user;

import com.apd.userservice.domain.dto.UserDTO;
import com.apd.userservice.domain.port.PasswordBCryptPort;
import com.apd.userservice.domain.port.UserPort;
import com.apd.userservice.usecase.validation.UserValidation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
class UserUseCaseImpl implements UserUseCase {

    private final PasswordBCryptPort passwordBCryptPort;
    private final UserValidation userValidation;
    private final UserPort userPort;

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        userValidation.userRequestValidation(userDTO);
        userDTO.setPassword(passwordBCryptPort.encode(userDTO.getPassword()));
        return userPort.registerUser(userDTO);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userPort.fetchAllUsers();
    }
}
