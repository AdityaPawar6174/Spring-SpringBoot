package com.aditya.EmployeeManagementSystem.beans;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    @NotBlank(message = "Name is required")
    private @Getter @Setter String name;

    @NotBlank(message = "Role is required")
    private @Getter @Setter String role;

    @NotBlank(message = "Department is required")
    private @Getter @Setter String department;

    @NotNull(message = "Salary is mandatory")
    private @Getter @Setter double salary;

    @NotBlank(message = "Location is required")
    private @Getter @Setter String location;

    public Employees(int employeeId, double salary, String location, String name, String role, String department) {
        this.employeeId = employeeId;
        this.salary = salary;
        this.location = location;
        this.name = name;
        this.role = role;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", location='" + location + '\'' +
                '}';
    }
}
