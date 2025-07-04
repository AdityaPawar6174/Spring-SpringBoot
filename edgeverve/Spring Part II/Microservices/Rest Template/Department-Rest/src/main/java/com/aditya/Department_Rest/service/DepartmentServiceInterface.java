package com.aditya.Department_Rest.service;

import com.aditya.Department_Rest.model.Departments;

public interface DepartmentServiceInterface {
    Departments saveDepartment(Departments departments);
    Departments getDepartmentById(long id);
}
