package org.adiitya.Scenario1.services;

import org.adiitya.Scenario1.Repos.PublisherRepo;
import org.adiitya.Scenario1.beans.Book;
import org.adiitya.Scenario1.beans.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepo publisherRepo;

    public void publishBooks(Publisher publisher){
        publisherRepo.save(publisher);
    }
}
