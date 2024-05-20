package com.applicationone.userinformation.controller;

import com.applicationone.userinformation.dto.UserDto;
import com.applicationone.userinformation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto user){
        UserDto userAdded = this.userService.addUser(user);
        return new ResponseEntity<>(userAdded, HttpStatus.CREATED);
    }

    @GetMapping("/fetchUserById/{userId}")
    public ResponseEntity<UserDto> fetchUserById(@PathVariable Long userId){
        return this.userService.fetchUserById(userId);

    }
}
