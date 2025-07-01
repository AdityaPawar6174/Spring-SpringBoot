package com.aditya.Department_Rest.controller;

import com.aditya.Department_Rest.model.Departments;
import com.aditya.Department_Rest.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Departments> saveDepartment(@RequestBody Departments departments) {
        Departments savedDepartment = departmentService.saveDepartment(departments);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departments> getDepartmentById(@PathVariable("id") long id){
        Departments department = departmentService.getDepartmentById(id);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }
}
