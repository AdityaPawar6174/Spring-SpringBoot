package org.adiitya.Scenario1.Repos;

import org.adiitya.Scenario1.beans.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {
}
