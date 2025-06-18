package org.adiitya.Scenario1.Repos;

import org.adiitya.Scenario1.beans.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Integer> {
}
