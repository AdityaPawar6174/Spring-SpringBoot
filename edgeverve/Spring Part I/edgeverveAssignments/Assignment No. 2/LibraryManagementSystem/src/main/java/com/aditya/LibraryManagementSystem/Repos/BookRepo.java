package com.aditya.LibraryManagementSystem.Repos;

import com.aditya.LibraryManagementSystem.Beans.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book,Integer> {

    public List<Book> findByAuthor(String author);

    public List<Book> findByGenre(String genre);

    public List<Book> findByPublicationYearGreaterThan(int year);
}
