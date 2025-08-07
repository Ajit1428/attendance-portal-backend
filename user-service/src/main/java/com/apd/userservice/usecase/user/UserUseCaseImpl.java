package com.apd.userservice.usecase.user;

import com.apd.userservice.domain.dto.UserDTO;
import com.apd.userservice.domain.port.PasswordBCryptPort;
import com.apd.userservice.domain.port.UserPort;
import com.apd.userservice.usecase.validation.UserValidation;
import com.apd.userservice.utils.JwtUtil;
import com.nimbusds.jose.JOSEException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@AllArgsConstructor
class UserUseCaseImpl implements UserUseCase {

    private final PasswordBCryptPort passwordBCryptPort;
    private final UserValidation userValidation;
    private final UserPort userPort;
    private final JwtUtil jwtUtil;

    @Override
    public Map<String, String> userLogin(String email, String password) throws JOSEException {
        Map<String, String> accessToken = new HashMap<>();
        userValidation.userLoginRequestValidation(email, password);
        var existingPassword = userPort.getUserByEmail(email);
        var validPassword = passwordBCryptPort.matches(password, existingPassword.getPassword());
        if(validPassword){
            var encodedAccessToken =  jwtUtil.generateToken(existingPassword.getEmail(), existingPassword.getId());
            accessToken.put("accessToken", encodedAccessToken);
        }else{
            accessToken.put("message", "The password that you have entered is incorrect");
        }
        return accessToken;

    }

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        userValidation.userRegisterRequestValidation(userDTO);
        userDTO.setPassword(passwordBCryptPort.encode(userDTO.getPassword()));
        return userPort.registerUser(userDTO);
    }

    @Override
    public UserDTO getUserById(UUID userId) {
        if(userId == null){
            return null;
        }
        return userPort.fetchUserById(userId);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userPort.fetchAllUsers();
    }
}
