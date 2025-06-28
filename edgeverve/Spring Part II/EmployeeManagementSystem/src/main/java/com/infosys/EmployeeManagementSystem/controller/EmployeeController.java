package com.infosys.EmployeeManagementSystem.controller;

import com.infosys.EmployeeManagementSystem.model.Employee;
import com.infosys.EmployeeManagementSystem.service.Implementation.EmployeeServiceImp;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

    EmployeeServiceImp employeeServiceImp;

    public  EmployeeController(EmployeeServiceImp employeeServiceImp){
        this.employeeServiceImp = employeeServiceImp;
    }

    @PostMapping("/addEmp")
    public String createEmployeeDetails(@RequestBody Employee employee){
        employeeServiceImp.createEmployee(employee);
        return "Saved!";
    }

    @GetMapping("/{empId}")
    public Employee getEmployeeDetails(@PathVariable("empId") int empId){
        return employeeServiceImp.getEmployee(empId);
    }

    @PutMapping("/updateEmp")
    public String updateEmployeeDetails(@RequestBody Employee employee){
        employeeServiceImp.updateEmployee(employee);
        return "Updated!";
    }

    @DeleteMapping("deleteEmp/{empId}")
    public String deleteEmployeeDetails(@PathVariable("empId") int empId){
        return employeeServiceImp.deleteEmployee(empId);
    }

    @GetMapping("/AllEmployees")
    public List<Employee> getAllEmployeeDetails(){
        return employeeServiceImp.getAllEmployee();
    }
}
