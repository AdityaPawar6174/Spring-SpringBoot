package com.aditya.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class Project {

    private String projectName;
    private Department department;
    private Employee employee;

    @Autowired
    public Project(Employee employee) {
        this.employee = employee;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Department getDepartment() {
        return department;
    }

    @Autowired
    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectName='" + projectName + '\'' +
                ", department=" + department +
                ", employee=" + employee.getEmpName() +
                '}';
    }
}
