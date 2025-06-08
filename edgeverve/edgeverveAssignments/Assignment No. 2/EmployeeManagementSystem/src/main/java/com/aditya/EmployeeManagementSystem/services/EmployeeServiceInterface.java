package com.aditya.EmployeeManagementSystem.services;

import com.aditya.EmployeeManagementSystem.beans.Employees;

import java.util.List;

public interface EmployeeServiceInterface {

    public void addEmployee(Employees employees);

    public Employees getEmployeeById(int employeeId);

    public List<Employees> getAllEmployees();

    public void updateEmployee(Employees employees);

    public void deleteEmploye(int empId);

    List<Employees> filterByDepartment(String department);
    List<Employees> filterByRole(String role);
    List<Employees> filterByLocation(String location);
}
