package com.aditya.EmployeeManagementSystem.services;

import com.aditya.EmployeeManagementSystem.beans.Employees;
import com.aditya.EmployeeManagementSystem.repos.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements EmployeeServiceInterface {

    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public void addEmployee(Employees employees) {
        employeeRepo.save(employees);
    }

    @Override
    public Employees getEmployeeById(int employeeId) {
        return employeeRepo.findById(employeeId).orElse(null);
    }

    @Override
    public List<Employees> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public void updateEmployee(Employees employees) {
        employeeRepo.save(employees);
    }

    @Override
    public void deleteEmploye(int empId) {
        employeeRepo.deleteById(empId);
    }

    @Override
    public List<Employees> filterByDepartment(String department) {
        return employeeRepo.findByDepartment(department);
    }

    @Override
    public List<Employees> filterByRole(String role) {
        return employeeRepo.findByRole(role);
    }

    @Override
    public List<Employees> filterByLocation(String location) {
        return employeeRepo.findByLocation(location);
    }
}
