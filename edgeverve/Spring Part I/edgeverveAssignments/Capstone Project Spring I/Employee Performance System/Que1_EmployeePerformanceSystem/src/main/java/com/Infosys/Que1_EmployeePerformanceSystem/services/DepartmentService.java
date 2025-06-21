package com.Infosys.Que1_EmployeePerformanceSystem.services;

import com.Infosys.Que1_EmployeePerformanceSystem.beans.Department;
import com.Infosys.Que1_EmployeePerformanceSystem.repos.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    public void addDepartment(Department department) {
        departmentRepo.save(department);
    }

    public Department getDepartmentById(int id) {
        return departmentRepo.findById(id).orElse(null);
    }

    public List<Department> getAllDepartments() {
        return departmentRepo.findAll();
    }
}
