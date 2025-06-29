package com.aditya.BooksManagementRest.service.implementation;

import com.aditya.BooksManagementRest.model.Books;
import com.aditya.BooksManagementRest.repository.BooksRepo;
import com.aditya.BooksManagementRest.service.BookServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService implements BookServiceInterface {

    BooksRepo booksRepo;

    public BooksService(BooksRepo booksRepo) {
        this.booksRepo = booksRepo;
    }

    @Override
    public String addBook(Books book) {
        booksRepo.save(book);
        return "Book Added Successfully!!!";
    }

    @Override
    public String updateBook(Books book) {
        if (booksRepo.existsById(book.getId())) {
            booksRepo.save(book);
        }
        return "Book Updated Successfully!!!";
    }

    @Override
    public String deleteBook(int bookId) {
        booksRepo.deleteById(bookId);
        return "book deleted successfully!!!";
    }

    @Override
    public Books getBookById(int bookId) {
        return booksRepo.findById(bookId).orElse(null);
    }

    @Override
    public List<Books> getAllBooks() {
        return booksRepo.findAll();
    }
}
