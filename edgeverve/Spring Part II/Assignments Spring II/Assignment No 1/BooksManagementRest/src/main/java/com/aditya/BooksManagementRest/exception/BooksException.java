package com.aditya.BooksManagementRest.exception;

public class BooksException extends RuntimeException {

    public BooksException() {}

    public BooksException(int id) {
        super("Cannot find book with this Id: " + id);
    }
}
