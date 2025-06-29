package com.infosys.demoPostgreRest.service.impl;

import com.infosys.demoPostgreRest.Exception.CourseException;
import com.infosys.demoPostgreRest.model.Course;
import com.infosys.demoPostgreRest.repository.CourseRepo;
import com.infosys.demoPostgreRest.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    CourseRepo courseRepo;
    @Override
    public String createCourse(Course course) {
        courseRepo.save(course);
        return "Saved!";
    }

    @Override
    public String updateCourse(Course course) {
        courseRepo.save(course);
        return "Updated!";
    }

    @Override
    public String deleteCourse(int courseId) {
        courseRepo.deleteById(courseId);
        return "Deleted!";
    }

    @Override
    public Course getCourse(int courseId) {
        if (courseRepo.findById(courseId).isEmpty()){
            throw new CourseException(courseId);
        }
        return courseRepo.findById(courseId).get();
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepo.findAll();
    }
}
