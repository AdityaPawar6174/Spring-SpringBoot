package com.aditya.MappingDemo.beans;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="student")
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter int studentId;

    @Column(name = "sname")
    @NotBlank(message = "Student Name Is Mandatory")
    private @Getter @Setter String studentName;

    @Column(name = "semail")
    @NotBlank(message = "Email Required is valid")
    private @Getter @Setter String studentEmail;

    //----------------------------------------------------

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dept_id")
    private@Getter @Setter Department department;

    //-----------------------------------------------

    @ManyToMany
    // JoinTable mainly used with @ManyToMany mapping, sometimes with unidirectional @oneToOne mapping
    // it contains FKs pointing to primary keys of 2 related tables
    @JoinTable(name = "student_courses", //name of the join table
            joinColumns = @JoinColumn(name = "student_id"),  // FK referring to current entity(Stduent)
            inverseJoinColumns = @JoinColumn(name = "course_id")) // FK referring to other entity(Course)
    private @Getter @Setter List<Courses> coursesList;

    //-------------------------------------------------
    public Student(String studentEmail, String studentName) {
        this.studentEmail = studentEmail;
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentEmail='" + studentEmail + '\'' +
                '}';
    }
}
