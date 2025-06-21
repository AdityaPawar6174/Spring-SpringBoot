package com.Infosys.Que1_EmployeePerformanceSystem.repos;

import com.Infosys.Que1_EmployeePerformanceSystem.beans.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepo extends JpaRepository<Project,Integer> {
}
