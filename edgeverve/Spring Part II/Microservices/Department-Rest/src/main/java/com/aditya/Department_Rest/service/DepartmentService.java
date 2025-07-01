package com.aditya.Department_Rest.service;

import com.aditya.Department_Rest.model.Departments;
import com.aditya.Department_Rest.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService implements DepartmentServiceInterface{

    @Autowired
    public DepartmentRepo departmentRepo;

    @Override
    public Departments saveDepartment(Departments departments) {
        return departmentRepo.save(departments);
    }

    @Override
    public Departments getDepartmentById(long id) {
        return departmentRepo.findById(id).get();
    }
}
