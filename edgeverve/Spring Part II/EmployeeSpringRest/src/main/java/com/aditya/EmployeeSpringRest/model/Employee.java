package com.aditya.EmployeeSpringRest.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    private @Getter @Setter int employeeId;
    private @Getter @Setter String employeeName;
    private @Getter @Setter String employeeAddress;
    private @Getter @Setter String employeeContact;
}
