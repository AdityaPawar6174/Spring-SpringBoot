package com.infosys.AccountService.Controller;

import com.infosys.AccountService.Entity.Account;
import com.infosys.AccountService.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    @GetMapping
    public List<Account> getAll() {
        return service.getAllAccounts();
    }

    @Autowired
    public AccountService service;

    @GetMapping("/{id}")
    public Account getById(@PathVariable Long id) {
        return service.getAccountById(id).orElse(null);
    }

    @PostMapping("/addaccount")
    public Account create(@RequestBody Account account) {
        return service.createAccount(account);
    }

    @PutMapping("/{id}")
    public Account update(@PathVariable Long id, @RequestBody Account account) {
        return service.updateAccount(id, account);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteAccount(id);
    }
}
