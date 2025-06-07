package com.adityaaa.jpacurddemo.repos;

import com.adityaaa.jpacurddemo.beans.Batches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchRepo extends JpaRepository<Batches,Integer> {
}
