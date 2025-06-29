package com.aditya.BooksManagementRest.controller;

import com.aditya.BooksManagementRest.model.Books;
import com.aditya.BooksManagementRest.service.implementation.BooksService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-books")
public class BooksController {

    BooksService booksService;

    public BooksController(BooksService booksService){
        this.booksService = booksService;
    }

    @GetMapping("/books")
    public List<Books> getBooks(){
        return booksService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Books getBookById(@PathVariable("id") int bookId) {
        return booksService.getBookById(bookId);
    }

    @PostMapping("/books")
    public String addBook(@RequestBody Books book) {
        booksService.addBook(book);
        return "Book Added Successfully!!!";
    }

    @PutMapping("/books/{id}")
    public String updateBook(@RequestBody Books book, @PathVariable("id") int bookId) {
        book.setId(bookId);
        booksService.updateBook(book);
        return "Book Updated Successfully!!!";
    }

    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable ("id") int bookId) {
        booksService.deleteBook(bookId);
        return "Book Deleted Successfully!!!";
    }
}
