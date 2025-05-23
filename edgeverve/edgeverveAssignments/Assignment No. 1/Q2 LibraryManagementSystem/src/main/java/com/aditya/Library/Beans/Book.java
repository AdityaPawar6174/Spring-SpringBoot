package com.aditya.Library.Beans;

import org.springframework.stereotype.Component;

@Component
public class Book {

    private String title;

    public Book(){
    this.title = "The Spring Basics";
    }

    public Book(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void displayBook(){
        System.out.println("Book: "+title);
    }
}
