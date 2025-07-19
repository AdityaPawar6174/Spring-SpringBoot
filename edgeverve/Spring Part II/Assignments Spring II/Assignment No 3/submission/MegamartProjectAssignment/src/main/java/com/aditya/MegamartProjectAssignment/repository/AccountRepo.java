package com.aditya.MegamartProjectAssignment.repository;

import com.aditya.MegamartProjectAssignment.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepo extends JpaRepository<Account, String> {
    Optional<Account> findByNameAndPassword(String name, String password);
    public Boolean existsByEmail(String email);
}
