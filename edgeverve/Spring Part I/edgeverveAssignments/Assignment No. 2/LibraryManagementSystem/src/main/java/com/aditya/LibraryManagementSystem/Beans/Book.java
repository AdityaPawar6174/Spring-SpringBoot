package com.aditya.LibraryManagementSystem.Beans;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter int bookId;

    private @Getter @Setter String title;
    private @Getter @Setter String author;
    private @Getter @Setter String genre;
    private @Getter @Setter String isbn;
    private @Getter @Setter int publicationYear;
    private @Getter @Setter boolean available = true;

    public Book(boolean available, int publicationYear, String isbn, String genre, String author, String title, int bookId) {
        this.available = available;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.genre = genre;
        this.author = author;
        this.title = title;
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publicationYear=" + publicationYear +
                ", available=" + available +
                '}';
    }
}
