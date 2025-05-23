package com.aditya.beans;

import org.springframework.stereotype.Component;

@Component
public class Course {
    private String title = "Computer Enginnering";

    public String getCourse() {
        return title;
    }

    public void displayCourse(){
        System.out.println("Course: "+title);
    }
}
