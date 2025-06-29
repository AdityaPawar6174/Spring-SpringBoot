package com.aditya.BooksManagementRest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "books")
public class Books {
    @Id
    private int id;
    private String name;
    private String author;
    private String publisher;
    private double price;


}
