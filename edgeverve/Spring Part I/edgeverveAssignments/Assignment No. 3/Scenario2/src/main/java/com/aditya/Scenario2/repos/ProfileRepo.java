package com.aditya.Scenario2.repos;

import com.aditya.Scenario2.beans.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepo extends JpaRepository<Profile,Integer> {
}
