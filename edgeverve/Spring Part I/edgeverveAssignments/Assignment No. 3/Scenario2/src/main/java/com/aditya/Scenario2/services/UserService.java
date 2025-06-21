package com.aditya.Scenario2.services;

import com.aditya.Scenario2.beans.User;
import com.aditya.Scenario2.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public void addUser(User user) {
        userRepo.save(user);
    }

    public User getUserById(int id) {
        return userRepo.findById(id).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public void deleteUser(int id) {
        userRepo.deleteById(id);
    }

    public User updateUser(User user) {
        return userRepo.save(user);
    }
}
