package com.aditya.Scenario2.services;

import com.aditya.Scenario2.beans.Profile;
import com.aditya.Scenario2.repos.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepo profileRepo;

    public void addProfile(Profile profile) {
        profileRepo.save(profile);
    }

    public Profile getProfileById(int id) {
        return profileRepo.findById(id).orElse(null);
    }

    public void deleteProfile(int id) {
        profileRepo.deleteById(id);
    }

    public Profile updateProfile(Profile profile) {
        return profileRepo.save(profile);
    }

}
