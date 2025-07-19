package com.aditya.MegamartProjectAssignment.service;

import com.aditya.MegamartProjectAssignment.exception.GlobalExceptionHandler;
import com.aditya.MegamartProjectAssignment.model.Account;
import com.aditya.MegamartProjectAssignment.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepo accountRepo;

    @Autowired
    GlobalExceptionHandler exceptionHandler;

    public String register(Account account){

        if (account.getName().isEmpty()) return "Provide Name";
        if (account.getEmail().isEmpty()) return "Provide Email";
        if (account.getPassword().isEmpty()) return "Provide Password";

        if(!account.getName().matches("^[a-zA-Z\\s]+$")) {
            return "Name can only contain letters and spaces";
        }

        if (!account.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            return "Invalid Email Format";
        }

        if(accountRepo.existsByEmail(account.getEmail())){
            throw new IllegalArgumentException("Email already exists");
        }

        if(!account.getPassword().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d@$!%*?&]{6,}$")) {
            return "Password must be at least 8 characters long, contain at least one uppercase letter, one lowercase letter, and one number.";
        }

        if(!account.getPassword().equals(account.getConfirmPassword())) {
            return "Password does not Match";
        }

        accountRepo.save(account);
        return "Account Registered Successfully...";
    }


    public String login(String name, String password){

        if (name.isEmpty()) return "Provide Name";
        if (password.isEmpty()) return "Provide Password";

        // invalid username or password
//        if (!accountRepo.existsById(account.getName())){
//            return "Invalid Username or Password";
//        }
//
//        Account existingAccount = accountRepo.findById(account.getName()).orElse(null);
//        if (existingAccount == null || !existingAccount.getPassword().equals(account.getPassword())) {
//            return "Invalid Username or Password";
//        }

//        return "Account Login Successful...";

        return accountRepo.findByNameAndPassword(name, password)
                .map(account -> "Login successful")
                .orElse("Invalid username or password");

    }

    public List<Account> getAllAccounts() {
        return accountRepo.findAll();
    }

    public void deleteAccountByName(String name) {
        accountRepo.deleteById(name);
    }
}
