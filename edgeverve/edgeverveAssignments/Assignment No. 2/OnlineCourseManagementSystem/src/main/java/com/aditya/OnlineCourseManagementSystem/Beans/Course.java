package com.aditya.OnlineCourseManagementSystem.Beans;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter int courseId;
    @NotBlank(message = "Title cannot be blank")
    private @Getter @Setter String title;
    @Column(columnDefinition = "TEXT")
    private @Getter @Setter String description;
    @NotBlank(message = "Instructor Name Required")
    private @Getter @Setter String instructor;
    private @Getter @Setter String category;

    private @Getter @Setter LocalDate startDate;
    private @Getter @Setter LocalDate endDate;

    public Course(int courseId, String title, String category, String instructor, String description, LocalDate startDate, LocalDate endDate) {
        this.courseId = courseId;
        this.title = title;
        this.category = category;
        this.instructor = instructor;
        this.description = description;
        this.endDate = endDate;
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", instructor='" + instructor + '\'' +
                ", category='" + category + '\'' +
                ", start=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
