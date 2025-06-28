package com.infosys.EmployeeManagementSystem.service.Implementation;

import com.infosys.EmployeeManagementSystem.model.Employee;
import com.infosys.EmployeeManagementSystem.repository.EmployeeRepo;
import com.infosys.EmployeeManagementSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;
    @Override
    public String createEmployee(Employee employee) {
        employeeRepo.save(employee);
        return "Saved!";
    }

    @Override
    public String updateEmployee(Employee employee) {
        employeeRepo.save(employee);
        return "Updated successfully!";
    }

    @Override
    public String deleteEmployee(int empId) {
        employeeRepo.deleteById(empId);
        return "Deleted!";
    }

    @Override
    public Employee getEmployee(int empId) {
        return employeeRepo.findById(empId).get();
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepo.findAll();
    }
}
