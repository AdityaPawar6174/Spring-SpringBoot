package org.adiitya.Scenario1.services;

import org.adiitya.Scenario1.Repos.LibraryBranchRepo;
import org.adiitya.Scenario1.beans.LibraryBranch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryBranchService {

    @Autowired
    private LibraryBranchRepo branchRepo;

    public void addBranch(LibraryBranch branch){
        branchRepo.save(branch);
    }

    public LibraryBranch getBranchById(int id){
        return branchRepo.findById(id).orElse(null);
    }

    public List<LibraryBranch> getAllBranches(){
        return branchRepo.findAll();
    }
}
