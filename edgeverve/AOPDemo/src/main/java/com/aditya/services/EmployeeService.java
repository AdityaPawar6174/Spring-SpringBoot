package com.aditya.services;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EmployeeService implements EmployeeRepo {

    @Override
    public void joiningDate(){
        System.out.println("Employee Joining Date: "+new Date());
    }

    @Override
    public void endDate(){
        System.out.println("Employee Last Date: "+"21-05-2026");
    }
}
