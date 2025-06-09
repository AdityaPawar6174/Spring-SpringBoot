package com.aditya.CustomerRelationshipManagement.repos;

import com.aditya.CustomerRelationshipManagement.beans.Interaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface InteractionRepo extends JpaRepository<Interaction,Integer> {

    List<Interaction> findByProduct(String product);

    List<Interaction> findByDateBetween(LocalDate start, LocalDate end);

    List<Interaction> findByRating(int rating);

}
