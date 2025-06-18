package org.adiitya.Scenario1.services;

import org.adiitya.Scenario1.Repos.AuthorRepo;
import org.adiitya.Scenario1.beans.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepo authorRepo;

    public void addAuthor(Author author) {
        authorRepo.save(author);
    }

    public Author getAuthorById(int id) {
        return authorRepo.findById(id).orElse(null);
    }

    public List<Author> getAllAuthors() {
        return authorRepo.findAll();
    }

    public void updateAuthor(Author author) {
        authorRepo.save(author);
    }

    public void deleteAuthor(int id) {
        authorRepo.deleteById(id);
    }
}
