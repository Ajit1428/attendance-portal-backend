package com.apd.userservice.adapter.user;

import com.apd.userservice.domain.dto.UserDTO;
import com.apd.userservice.domain.port.UserPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

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

    @Override
    public UserDTO getUserByEmail(String email) {
        var getUserByEmailResponse = userJPARepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found with the given email"));
        return userMapper.toRawUserDTO(getUserByEmailResponse);
    }

    @Override
    public UserDTO fetchUserById(UUID userId) {
        var userEntity = userJPARepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found with the given Id"));
        return userMapper.toUserDTO(userEntity);
    }
}
