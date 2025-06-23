package com.aditya.EmployeeSpringRest.controller;

import com.aditya.EmployeeSpringRest.model.Employee;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeService {

    Employee employee;

    // Method to get employee details
     @GetMapping("{employeeId}")
     public Employee getEmployeeDetails(int employeeId) {
         return employee;
     }

    // Method to create employee details
    @PostMapping
    public String createEmployeeDetails(Employee employee) {
        this.employee = employee;
        return "Employee created successfully ....";
    }

    // Method to update employee details
    @PutMapping
    public String updateEmployeeDetails(Employee employee) {
        this.employee = employee;
        return "Employee updated successfully ....";
    }

    // Method to delete employee details
    @DeleteMapping
    public String deleteEmployeeDetails(int employeeId) {
        this.employee = null;
        return "Employee deleted successfully ....";
    }

}
