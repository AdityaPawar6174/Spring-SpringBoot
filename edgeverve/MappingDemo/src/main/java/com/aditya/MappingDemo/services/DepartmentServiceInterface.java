package com.aditya.MappingDemo.services;

import com.aditya.MappingDemo.beans.Department;

import java.util.List;

public interface DepartmentServiceInterface {

    public void saveDepartment(Department department);

    public List<Department> getAllDepartment();

    public Department findDepartmentOnBasisOfId(int deptId);
}
