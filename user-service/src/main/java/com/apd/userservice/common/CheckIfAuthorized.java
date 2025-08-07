package com.apd.userservice.common;

import com.apd.userservice.usecase.user.UserUseCase;
import com.apd.userservice.utils.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class CheckIfAuthorized {

    private final JwtUtil jwtUtil;
    private final UserUseCase userUseCase;

    //TODO: Need to validate the expiry time as well
    public boolean isAuthorizedUser(String authHeader) throws Exception {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return false;
        }

        var accessToken = authHeader.split(" ")[1];
        var decodedToken = jwtUtil.getDecodedToken(accessToken);
        var userId = decodedToken.get("userId");
        var userEmail = decodedToken.get("email");
        var userDetails = userUseCase.getUserById(UUID.fromString(userId));

        return userDetails.getEmail().equals(userEmail);
    }
}
