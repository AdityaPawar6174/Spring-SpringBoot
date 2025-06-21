package com.Infosys.Que1_EmployeePerformanceSystem.repos;

import com.Infosys.Que1_EmployeePerformanceSystem.beans.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Integer> {
}
