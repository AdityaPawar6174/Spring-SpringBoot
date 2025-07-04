package com.aditya.User_Rest.controller;

import com.aditya.User_Rest.model.ResponseDto;
import com.aditya.User_Rest.model.User;
import com.aditya.User_Rest.service.UserService;
import org.apache.tomcat.util.buf.UEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getUserDetails(@PathVariable("id") Long id){
        ResponseDto responseDto = userService.getUser(id);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/user/{id}")
    public User getUserDetail(@PathVariable("id") Long id) {
        return userService.getUserDetail(id);
    }
}
