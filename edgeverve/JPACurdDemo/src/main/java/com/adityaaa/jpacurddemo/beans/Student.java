package com.adityaaa.jpacurddemo.beans;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tb_student")
@NoArgsConstructor
@NamedQuery(
        name = "Student.findAllStudents",
        query = "SELECT s FROM Student s"
)
@NamedQuery(
        name = "Student.findByEmail",
        query = "SELECT s FROM Student s WHERE s.studentEmail=:email"
)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter int studentId;
    @Column(name = "sname")
    @NotBlank(message = "Student Name Is Mandatory")
    private @Getter @Setter String studentName;
    @Column(name = "semail")
    @Email(message = "Email Required is valid")
    private @Getter @Setter String studentEmail;

    public Student(String studentEmail, String studentName) {
        this.studentEmail = studentEmail;
        this.studentName = studentName;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Laptop.class)
    @JoinColumn(name = "laptop_id", referencedColumnName = "macId", nullable = true)
    private @Getter @Setter Laptop laptop;

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentEmail='" + studentEmail + '\'' +
                '}';
    }
}
