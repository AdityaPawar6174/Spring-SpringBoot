package com.aditya.Employee_service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeResponseDTO {
    private Long empId;
    private String empName;
    private Double empSalary;

    private Long deptId;
    private String deptName;
    private Long managerId;
}
