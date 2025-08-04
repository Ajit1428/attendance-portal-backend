package com.apd.userservice.adapter.user;

import com.apd.userservice.domain.dto.UserDTO;
import com.apd.userservice.domain.port.UserPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class UserAdapter implements UserPort {
    private final UserJPARepository userJPARepository;
    private final UserMapper userMapper;

    UserAdapter(UserJPARepository userJPARepository, UserMapper userMapper) {
        this.userJPARepository = userJPARepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDTO> fetchAllUsers() {
        var allUsers = userJPARepository.findAll();
        return allUsers.stream()
                .map(userMapper::toUserDTO)
                .toList();
    }

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        var userToEntity = userMapper.toEntity(userDTO);
        var userSavedResponse = userJPARepository.save(userToEntity);
        return userMapper.toUserDTO(userSavedResponse);
    }
}
