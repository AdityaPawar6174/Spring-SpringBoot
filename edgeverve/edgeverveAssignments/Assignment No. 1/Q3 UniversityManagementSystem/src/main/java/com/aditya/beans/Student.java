package com.aditya.beans;

import org.springframework.stereotype.Component;

@Component
public class Student {

    private String name = "Aditya";

    public String getName() {
        return name;
    }

    public void displayStudent() {
        System.out.println("Student: "+name);
    }
}
