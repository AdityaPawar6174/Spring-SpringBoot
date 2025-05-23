package com.aditya.app;

import com.aditya.app.model.Laptop;
import org.springframework.stereotype.Repository;

@Repository //marks class as repository component
// used for data access operations like CRUD
public class LaptopRepository {
    public void save(Laptop laptop ){
        // JDBC Steps here
        System.out.println("Saved in Database...");
    }
}
