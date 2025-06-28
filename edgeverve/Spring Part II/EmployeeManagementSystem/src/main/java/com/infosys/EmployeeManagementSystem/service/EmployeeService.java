package com.infosys.EmployeeManagementSystem.service;

import com.infosys.EmployeeManagementSystem.model.Employee;

import java.util.List;

public interface EmployeeService {
    public String createEmployee(Employee employee);
    public String updateEmployee(Employee employee);
    public String deleteEmployee(int empId);
    public Employee getEmployee(int empId);
    public List<Employee> getAllEmployee();
}
