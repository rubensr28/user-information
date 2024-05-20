package com.applicationone.userinformation.service;

import com.applicationone.userinformation.dto.UserDto;
import com.applicationone.userinformation.entity.User;
import com.applicationone.userinformation.mapper.UserMapper;
import com.applicationone.userinformation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private final UserMapper MAPPER = UserMapper.INSTANCE;

    public UserDto addUser(UserDto userDto) {

        User user = MAPPER.mapUserDtotoUser(userDto);
        return MAPPER.mapUsertoUserDto(userRepository.save(user));
    }

    public ResponseEntity<UserDto> fetchUserById(Long userId) {

        Optional<User> userFound = this.userRepository.findById(userId);

        return userFound.map(user ->
                        new ResponseEntity<UserDto>(MAPPER.mapUsertoUserDto(user), HttpStatus.OK))
                .orElse(new ResponseEntity<UserDto>(HttpStatus.NOT_FOUND));
    }
}
