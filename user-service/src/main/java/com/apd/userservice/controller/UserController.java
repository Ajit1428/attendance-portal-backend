package com.apd.userservice.controller;


import com.apd.userservice.domain.dto.UserDTO;
import com.apd.userservice.usecase.user.UserUseCase;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController
@AllArgsConstructor
class UserController {
    private final UserUseCase userUseCase;

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        var allUserResponse = userUseCase.getAllUsers();
        return ResponseEntity.status(200).body(allUserResponse);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@Valid  @RequestBody UserDTO userDTO){
        var registerUserResponse = userUseCase.registerUser(userDTO);
        return ResponseEntity.status(200).body(registerUserResponse);

    }
}
