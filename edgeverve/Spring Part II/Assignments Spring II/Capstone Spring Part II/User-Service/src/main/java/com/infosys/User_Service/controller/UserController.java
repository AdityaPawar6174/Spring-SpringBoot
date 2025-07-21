package com.infosys.User_Service.controller;

import com.infosys.User_Service.model.User;
import com.infosys.User_Service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody  User user){
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable int userId){
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable int userId, @RequestBody User user){
        return ResponseEntity.ok(userService.updateUser(userId, user));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("Success");
    }

    @PostMapping("/{userId}/assign-terminal/{terminalId}")
    public ResponseEntity<Void> assignTerminal(
            @PathVariable int userId,
            @PathVariable String terminalId) {
        userService.assignTerminalToUser(userId, terminalId);
        return ResponseEntity.ok().build();
    }
}
