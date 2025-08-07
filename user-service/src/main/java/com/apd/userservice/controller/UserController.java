package com.apd.userservice.controller;

import com.apd.userservice.common.CheckIfAuthorized;
import com.apd.userservice.domain.dto.UserDTO;
import com.apd.userservice.domain.dto.UserLoginRequestDTO;
import com.apd.userservice.usecase.user.UserUseCase;
import com.nimbusds.jose.JOSEException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RequestMapping("/user")
@RestController
@AllArgsConstructor
class UserController {
    private final UserUseCase userUseCase;
    private final CheckIfAuthorized checkIfAuthorized;

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDTO>> getAllUsers(@RequestHeader("Authorizations") String authHeader) throws Exception {
        if(!checkIfAuthorized.isAuthorizedUser(authHeader)){
            return ResponseEntity.status(401).body(Collections.emptyList());
        }
        var allUserResponse = userUseCase.getAllUsers();
        return ResponseEntity.status(200).body(allUserResponse);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@Valid @RequestBody UserDTO userDTO) {
        var registerUserResponse = userUseCase.registerUser(userDTO);
        return ResponseEntity.status(200).body(registerUserResponse);

    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@Valid @RequestBody UserLoginRequestDTO userLoginRequestDTO) throws JOSEException {
        var loginUserResponse = userUseCase.userLogin(userLoginRequestDTO.getEmail(), userLoginRequestDTO.getPassword());
        return ResponseEntity.status(200).body(loginUserResponse);
    }
}
