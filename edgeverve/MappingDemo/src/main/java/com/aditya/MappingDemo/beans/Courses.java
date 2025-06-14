package com.aditya.MappingDemo.beans;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter int courseId;

    @NotBlank(message = "Courses name should not be empty")
    private @Getter @Setter String courseName;

    @ManyToMany(mappedBy = "coursesList")
    private @Getter @Setter List<Student> enrolledStudentList;
}
