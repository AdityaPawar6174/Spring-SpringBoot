package com.aditya.app.services;

import com.aditya.app.LaptopRepository;
import com.aditya.app.model.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // this marks class as service component (specialization of component)
// used to denote the class that has business logic
public class LaptopService {

    @Autowired
    private LaptopRepository repo;

    public void addLaptop(Laptop laptop) {
//        System.out.println("Method Called");
        repo.save(laptop);

    }

    public boolean isGoodForProgramming(Laptop laptop){
        return true;
    }
}
