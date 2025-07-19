package com.aditya.MegamartProjectAssignment.controller;

import com.aditya.MegamartProjectAssignment.model.Account;
import com.aditya.MegamartProjectAssignment.repository.AccountRepo;
import com.aditya.MegamartProjectAssignment.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/account")
@CrossOrigin(origins = "http://localhost:3000")
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
    public ResponseEntity<String> login(@RequestParam String name,
                                        @RequestParam String password) {
        String result = accountService.login(name, password);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Account>> getAllAccounts(){
        List<Account> accounts = accountService.getAllAccounts();
        if (accounts.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        else {
            return ResponseEntity.ok(accounts);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAccount(@RequestParam String name){
        if (!accountRepo.existsById(name)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found");
        }
        accountService.deleteAccountByName(name);
        return ResponseEntity.ok("Account deleted Successfully");
    }


}
