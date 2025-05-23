package com.aditya.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniversityService {

    private Student student;
    private Course course;

    @Autowired
    public void setStudent(Student student){
        this.student = student;
    }

    @Autowired
    public void setCourse(Course course){
        this.course = course;
    }

    public void enrollStudent(){
        System.out.println("Student Enrollment Begins");
        student.displayStudent();
        course.displayCourse();
        System.out.println("Enrollment is successfull..!");
    }

}
