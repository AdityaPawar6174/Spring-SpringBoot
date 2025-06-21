package com.adityaaa.jpacurddemo.repos;

import com.adityaaa.jpacurddemo.beans.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepo extends JpaRepository<Laptop,Integer> {

}
