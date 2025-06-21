package com.aditya.MappingDemo.repo;

import com.aditya.MappingDemo.beans.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Integer> {
}
