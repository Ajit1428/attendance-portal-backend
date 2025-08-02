package com.apd.userservice.usecase.user;

import com.apd.userservice.domain.dto.UserDTO;
import com.apd.userservice.domain.port.PasswordBCryptPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class UserUseCaseImpl implements UserUseCase {

    public final PasswordBCryptPort passwordBCryptPort;

    @Override
    public UserDTO registerUser(String name) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("kina empty haaleko");
        }

        return null;
    }
}
