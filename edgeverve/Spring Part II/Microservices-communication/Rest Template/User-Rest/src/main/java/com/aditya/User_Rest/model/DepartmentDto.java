package com.aditya.User_Rest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DepartmentDto {
    private long id;
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}

