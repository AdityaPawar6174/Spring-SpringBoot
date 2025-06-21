package org.adiitya.Scenario1.services;

import org.adiitya.Scenario1.Repos.PublisherRepo;
import org.adiitya.Scenario1.beans.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepo publisherRepo;

    public void addPublisher(Publisher publisher){
        publisherRepo.save(publisher);
    }

    public List<Publisher> getAllPublishers() {
        return publisherRepo.findAll();
    }

    public Publisher getPublisherById(int id){
        return publisherRepo.findById(id).orElse(null);
    }

    public void updatePublisher(Publisher publisher){
        publisherRepo.save(publisher);
    }

    public void deletePublisher(int id){
        publisherRepo.deleteById(id);
    }
}
