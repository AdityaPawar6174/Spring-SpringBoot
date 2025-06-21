package com.aditya.EmployeeManagementSystem.repos;

import com.aditya.EmployeeManagementSystem.beans.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employees,Integer> {
    List<Employees> findByDepartment(String department);
    List<Employees> findByRole(String role);
    List<Employees> findByLocation(String location);
}
