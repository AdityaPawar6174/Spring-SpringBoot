package com.infosys.demoPostgreRest.service;

import com.infosys.demoPostgreRest.model.Course;

import java.util.List;

public interface CourseService {
    public String createCourse(Course course);
    public String updateCourse(Course course);
    public String deleteCourse(int courseId);
    public Course getCourse(int courseId);
    public List<Course> getAllCourse();
}
