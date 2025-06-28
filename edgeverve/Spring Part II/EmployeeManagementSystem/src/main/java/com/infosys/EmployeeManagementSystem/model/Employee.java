package com.infosys.EmployeeManagementSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_employee")
public class Employee {

    @Id
    private int employee_id;

    private String employee_name;
    private String employee_dept;
    private String employee_salary;
}
