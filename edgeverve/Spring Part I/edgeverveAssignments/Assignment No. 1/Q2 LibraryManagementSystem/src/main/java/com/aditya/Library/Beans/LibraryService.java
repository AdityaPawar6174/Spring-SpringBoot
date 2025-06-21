package com.aditya.Library.Beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LibraryService {

    private Book book;

    private List<Book> books = new ArrayList<>();
    public Book getBook() {
        return book;
    }

    @Autowired // Setter Dependency Injection
    public void setBook(Book book) {
        this.book = book;
        books.add(book);
    }

    public void showLibrary() {
        System.out.println("Library consists below listed books: ");
        for (Book b : books) {
            b.displayBook();
        }
        System.out.println("\n");
    }
}
