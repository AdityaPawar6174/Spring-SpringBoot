package com.infosys.User_Service.service;

import com.infosys.User_Service.feign.TerminalServiceClient;
import com.infosys.User_Service.model.User;
import com.infosys.User_Service.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    TerminalServiceClient terminalClient;

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public User getUserById(int userId) {
        return userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User Id not Found"));
    }

    public User updateUser(int userId, User user) {
        User existingUser = getUserById(userId);

        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmailId(user.getEmailId());
        existingUser.setMobileNumber(user.getMobileNumber());
        existingUser.setPassword(user.getPassword());
        existingUser.setNationality(user.getNationality());
        existingUser.setPassportNumber(user.getPassportNumber());
        existingUser.setPermanentAddress(user.getPermanentAddress());
        existingUser.setOfficeAddress(user.getOfficeAddress());
        existingUser.setPersonalIdentificationNumber(user.getPersonalIdentificationNumber());

        return userRepo.save(existingUser);
    }

    public void deleteUser(int userId) {
        userRepo.deleteById(userId);
    }

    public void assignTerminalToUser(int userId, String terminalId) {
        User user = getUserById(userId);

        boolean isValidTerminal = terminalClient.validateTerminal(terminalId);
        if (!isValidTerminal) {
            throw new IllegalArgumentException("Invalid Terminal ID");
        }

        user.setAssignedTerminalId(terminalId);
        userRepo.save(user);
    }
}

