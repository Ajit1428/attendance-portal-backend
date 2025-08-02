package com.apd.userservice.adapter.user;

import com.apd.userservice.domain.dto.UserDTO;
import com.apd.userservice.domain.port.UserPort;
import org.springframework.stereotype.Component;

@Component
class UserAdapter implements UserPort {
    private  final UserJPARepository userJPARepository;

    UserAdapter(UserJPARepository userJPARepository) {
        this.userJPARepository = userJPARepository;
    }

    @Override
    public UserDTO registerUser(String name) {
        userJPARepository.save();
        return null;
    }
}
