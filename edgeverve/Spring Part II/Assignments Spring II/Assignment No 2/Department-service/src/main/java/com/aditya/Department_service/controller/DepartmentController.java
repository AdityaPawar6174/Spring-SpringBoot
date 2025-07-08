package com.aditya.Department_service.controller;

import com.aditya.Department_service.model.Department;
import com.aditya.Department_service.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepo departmentRepo;

    @GetMapping("/allDepartments")
    public List<Department> getAllDepartments(){
        return departmentRepo.findAll();
    }

    @PostMapping("/addDepartment")
    public Department addDepartment(@RequestBody Department department){
        return departmentRepo.save(department);
    }

    @GetMapping("/{deptId}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("deptId") Long deptId){
        Department department = departmentRepo.findById(deptId).orElseThrow(() -> new RuntimeException("Department ID Not Found: "+deptId ));
        return ResponseEntity.ok(department);
    }
}















