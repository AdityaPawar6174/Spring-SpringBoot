package com.aditya.BooksManagementRest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BooksResponse {
    private int statusCode;
    private String statusMsg;
    private Books book;
}
