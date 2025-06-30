package com.aditya.BooksManagementRest.service;

import com.aditya.BooksManagementRest.model.Books;

import java.util.List;

public interface BookServiceInterface {
    public String addBook(Books book);
    public String updateBook(Books book);
    public String deleteBook(int bookId);
    public Books getBookById(int bookId);
    public List<Books> getAllBooks();
}