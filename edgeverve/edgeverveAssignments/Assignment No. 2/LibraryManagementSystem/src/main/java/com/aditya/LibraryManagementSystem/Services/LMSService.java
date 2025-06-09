package com.aditya.LibraryManagementSystem.Services;

import com.aditya.LibraryManagementSystem.Beans.Book;
import com.aditya.LibraryManagementSystem.Repos.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LMSService {

    @Autowired
    private BookRepo bookRepo;

    public void addBook(Book book) {
        bookRepo.save(book);
    }

    public Book getBookById(int id) {
        return bookRepo.findById(id).orElse(null);
    }

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public void updateBook(Book book) {
        bookRepo.save(book);
    }

    public void deleteBook(int id) {
        bookRepo.deleteById(id);
    }

    public List<Book> getBooksByAuthor(String author) {
        return bookRepo.findByAuthor(author);
    }

    public List<Book> getBooksByGenre(String genre) {
        return bookRepo.findByGenre(genre);
    }

    public List<Book> getBooksAfterYear(int year) {
        return bookRepo.findByPublicationYearGreaterThan(year);
    }
}
