package com.aditya.MappingDemo.services;

import com.aditya.MappingDemo.beans.Department;
import com.aditya.MappingDemo.repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements DepartmentServiceInterface{

    @Autowired
    private DepartmentRepo departmentRepo;


    @Override
    public void saveDepartment(Department department) {
        departmentRepo.save(department);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepo.findAll();
    }

    @Override
    public Department findDepartmentOnBasisOfId(int deptId) {
        return departmentRepo.findById(deptId).orElse(null);
    }

}
