package com.apd.userservice.controller;


import com.apd.userservice.usecase.user.UserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/user")
@RestController
@AllArgsConstructor
class UserController {
    private final UserUseCase userUseCase;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody String name){
        var userReponse = userUseCase.registerUser(name);
        return ResponseEntity.ok("hello");

    }
}
