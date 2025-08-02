package com.apd.userservice.domain.port;


public interface PasswordBCryptPort {
    String encode(String rawPassword);

    boolean matches(String rawPassword, String encodedPassword);
}
