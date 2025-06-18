package org.adiitya.Scenario1.Repos;

import org.adiitya.Scenario1.beans.LibraryBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryBranchRepo extends JpaRepository<LibraryBranch, Integer> {
}
