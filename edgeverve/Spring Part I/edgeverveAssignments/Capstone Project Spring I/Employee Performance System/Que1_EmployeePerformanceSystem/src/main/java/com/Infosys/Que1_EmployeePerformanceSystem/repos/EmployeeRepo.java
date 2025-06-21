package com.Infosys.Que1_EmployeePerformanceSystem.repos;

import com.Infosys.Que1_EmployeePerformanceSystem.beans.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
}
