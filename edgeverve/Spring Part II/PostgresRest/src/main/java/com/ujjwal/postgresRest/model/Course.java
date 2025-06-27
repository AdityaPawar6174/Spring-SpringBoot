package com.ujjwal.postgresRest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;
    @NotBlank(message = "course name cannot be empty !!!")
    @Size(min = 5 , message = "Course name length greater than 5")
    private String courseName;
    @NotBlank(message = "duration is required ")
    private int duration;

}
