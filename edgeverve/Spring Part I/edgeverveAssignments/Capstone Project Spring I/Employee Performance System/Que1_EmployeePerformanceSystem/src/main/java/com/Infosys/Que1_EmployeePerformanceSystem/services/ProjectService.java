package com.Infosys.Que1_EmployeePerformanceSystem.services;

import com.Infosys.Que1_EmployeePerformanceSystem.beans.Project;
import com.Infosys.Que1_EmployeePerformanceSystem.repos.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepo projectRepo;

    public void addProject(Project project) {
        projectRepo.save(project);
    }
    public Project getProjectById(int id) {
        return projectRepo.findById(id).orElse(null);
    }

}
