package org.adiitya.Scenario1.services;

import org.adiitya.Scenario1.Repos.BookRepo;
import org.adiitya.Scenario1.beans.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public void addBook(Book book){
        bookRepo.save(book);
    }

    public Book getBookById(int id){
        return bookRepo.findById(id).orElse(null);
    }

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public void updateBook(Book book){
        bookRepo.save(book);
    }

    public void deleteBook(int id){
        bookRepo.deleteById(id);
    }
}
