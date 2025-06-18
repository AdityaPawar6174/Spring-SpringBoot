package org.adiitya.Scenario1.Repos;

import org.adiitya.Scenario1.beans.Book;
import org.adiitya.Scenario1.beans.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublisherRepo extends JpaRepository<Publisher, Integer> {
}
