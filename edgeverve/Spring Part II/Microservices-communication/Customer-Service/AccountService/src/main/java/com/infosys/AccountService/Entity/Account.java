package com.infosys.AccountService.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
@Entity
public class Account {



        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long accountId;
        private String customerId;
        private String accountType;
        private String accountNumber;
        private int balance;
        private LocalDate openedDate;

     public  Account(){}
    public Account(String customerId, String accountType, String accountNumber, int balance, LocalDate openedDate) {
        this.customerId = customerId;
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.openedDate = openedDate;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public LocalDate getOpenedDate() {
        return openedDate;
    }

    public void setOpenedDate(LocalDate openedDate) {
        this.openedDate = openedDate;
    }
}
