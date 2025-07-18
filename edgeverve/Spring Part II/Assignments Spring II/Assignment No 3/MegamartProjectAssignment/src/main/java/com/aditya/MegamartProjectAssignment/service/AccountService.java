package com.aditya.MegamartProjectAssignment.service;

import com.aditya.MegamartProjectAssignment.exception.GlobalExceptionHandler;
import com.aditya.MegamartProjectAssignment.model.Account;
import com.aditya.MegamartProjectAssignment.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    AccountRepo accountRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    public String register(Account registerRequest){

        // Validate input
        if (accountRepo.findByName(registerRequest.getName()).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }

        if (accountRepo.existsByEmail(registerRequest.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }


        if (registerRequest.getName().isEmpty()) return "Provide Name";
        if (registerRequest.getEmail().isEmpty()) return "Provide Email";
        if (registerRequest.getPassword().isEmpty()) return "Provide Password";

        if(!registerRequest.getName().matches("^[a-zA-Z\\s]+$")) {
            return "Name can only contain letters and spaces";
        }

        if (!registerRequest.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            return "Invalid Email Format";
        }


        if(!registerRequest.getPassword().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d@$!%*?&]{6,}$")) {
            return "Password must be at least 8 characters long, contain at least one uppercase letter, one lowercase letter, and one number.";
        }

        if(!registerRequest.getPassword().equals(registerRequest.getConfirmPassword())) {
            return "Password does not Match";
        }

        // Hash password before saving
        registerRequest.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

        accountRepo.save(registerRequest);
        return "Registration Successful...!";
    }


    public String login(Account loginRequest){

        if (loginRequest.getName() == null || loginRequest.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }

        if (loginRequest.getPassword() == null || loginRequest.getPassword().trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }

        if (loginRequest.getName().isEmpty()) return "Provide Name";
        if (loginRequest.getPassword().isEmpty()) return "Provide Password";

        // Find by name (not ID)
        Account account = accountRepo.findByName(loginRequest.getName())
                .orElseThrow(() -> new IllegalArgumentException("Invalid credentials"));

        // Verify password
        if (!passwordEncoder.matches(loginRequest.getPassword(), account.getPassword())) {
            throw new IllegalArgumentException("Invalid credentials");
        }

        return "Login Successful...!";
    }
}
