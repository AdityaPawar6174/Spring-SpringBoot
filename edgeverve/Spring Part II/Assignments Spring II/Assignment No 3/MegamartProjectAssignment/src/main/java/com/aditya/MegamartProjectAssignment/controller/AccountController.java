package com.aditya.MegamartProjectAssignment.controller;

import com.aditya.MegamartProjectAssignment.model.Account;
import com.aditya.MegamartProjectAssignment.repository.AccountRepo;
import com.aditya.MegamartProjectAssignment.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    AccountRepo accountRepo;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Account account){
        String result = accountService.register(account);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Account loginRequest){

        Optional<Account> optionalAccount = accountRepo.findById(loginRequest.getName());

        if (optionalAccount.isEmpty()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Username or Password");
        }

        Account account = optionalAccount.get();

        if (account.getPassword() == null || !account.getPassword().equals(loginRequest.getPassword())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Username or Password");
        }

        return ResponseEntity.ok("Account Login Successful...");
    }
}
