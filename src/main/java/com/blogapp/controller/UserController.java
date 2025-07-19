package com.blogapp.controller;


import com.blogapp.payload.UserDto;
import com.blogapp.service.UserService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    //Create USER
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto createdUser = this.userService.createUser(userDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    //UPDATE USER
    @PutMapping("/{userId}")
    public  ResponseEntity<UserDto> updateUser(
            @RequestBody UserDto userDto,
            @PathVariable("userId") Integer uid){
        UserDto updateUser = this.userService.updateUser(userDto,uid);
        return ResponseEntity.ok(updateUser);
    }

    //DELETE USER
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") Integer uid){
        this.userService.deleteUser(uid);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }

    // GET ALL USERS
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

    // GET a SINGLE USER BY ID
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId) {
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }

}
