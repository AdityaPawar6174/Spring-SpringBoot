package com.Infosys.Que1_EmployeePerformanceSystem.services;

import com.Infosys.Que1_EmployeePerformanceSystem.beans.Employee;
import com.Infosys.Que1_EmployeePerformanceSystem.beans.PerformanceReview;
import com.Infosys.Que1_EmployeePerformanceSystem.beans.Project;
import com.Infosys.Que1_EmployeePerformanceSystem.repos.EmployeeRepo;
import com.Infosys.Que1_EmployeePerformanceSystem.repos.PerformanceReviewRepo;
import com.Infosys.Que1_EmployeePerformanceSystem.repos.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ProjectRepo projectRepo;

    @Autowired
    private PerformanceReviewRepo performanceReviewRepo;

    // Adding employee
    public void addEmployee(Employee employee) {
        employeeRepo.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee getEmployeeById(int id) {
        return employeeRepo.findById(id).orElse(null);
    }

    public void assignProjects(int employeeId, List<Integer> projectIds) {
        Employee employee = employeeRepo.findById(employeeId).orElse(null);

        List<Project> projects = projectRepo.findAllById(projectIds);
        if (employee != null) {
            employee.getProjects().addAll(projects);
            employeeRepo.save(employee);
        } else {
            throw new RuntimeException("Employee not found");
        }

    }

    public void addPerformanceReview(int employeeId, PerformanceReview review) {
        Employee employee = employeeRepo.findById(employeeId).orElse(null);
        if (employee != null) {
            review.setEmployee(employee);
            performanceReviewRepo.save(review);
        } else {
            throw new RuntimeException("Employee not found");
        }
    }

}
