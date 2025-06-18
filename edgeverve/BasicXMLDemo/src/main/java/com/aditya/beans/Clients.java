package com.aditya.beans;

import java.util.List;
import java.util.Map;

public class Clients {

    private String name;
    private List<Employee> employeeList;
    private Map<String, Integer> resources;

    // Constructor for injecting employeeList
    public Clients(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Setter for resources
    public void setResources(Map<String, Integer> resources) {
        this.resources = resources;
    }

    // Display employee names
    public void showEmployees() {
        employeeList.forEach(employee -> {
            System.out.println(employee.getEmpName());
        });
    }

    // Display resources map
    public void showResourses() {
        if (resources != null) {
            for (Map.Entry<String, Integer> entry : resources.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        } else {
            System.out.println("No resources assigned.");
        }
    }

    @Override
    public String toString() {
        return "Clients{" +
                "name='" + name + '\'' +
                ", employeeList=" + employeeList +
                ", resources=" + resources +
                '}';
    }
}
