package com.aditya.Department_Rest.repository;

import com.aditya.Department_Rest.model.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Departments, Long> {
}
