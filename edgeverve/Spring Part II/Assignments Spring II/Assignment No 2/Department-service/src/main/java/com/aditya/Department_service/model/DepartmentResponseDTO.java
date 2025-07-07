package com.aditya.Department_service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DepartmentResponseDTO {
    private Long deptId;
    private String deptName;
    private Long managerId;

    private String empName;
    private Double empSalary;
}
