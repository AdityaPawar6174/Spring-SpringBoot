package com.aditya.Employee_service.controller;

import com.aditya.Employee_service.model.Employee;
import com.aditya.Employee_service.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeRepo.save(employee);
    }

    @GetMapping("/{empId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("empId") Long empId){
        Employee employee = employeeRepo.findById(empId).orElseThrow(() -> new RuntimeException("employee ID Not Found: "+empId ));
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/allEmployees")
    public List<Employee> getAllEmployees(){
        return employeeRepo.findAll();
    }
}
