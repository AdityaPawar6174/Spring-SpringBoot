package com.aditya.MappingDemo.beans;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter int deptId;

    @NotBlank(message = "Department name cannot be empty")
    private @Getter @Setter String deptName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private @Getter @Setter List<Student> studentList;

    public Department(String deptName) {
        this.deptName = deptName;
    }


}
