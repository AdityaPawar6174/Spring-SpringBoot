package com.aditya.OnlineCourseManagementSystem.Service;

import com.aditya.OnlineCourseManagementSystem.Beans.Course;
import com.aditya.OnlineCourseManagementSystem.Repo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public void addCourse(Course course){
        courseRepository.save(course);
    }

    public Course getCourseById(int courseId){
        return courseRepository.findById(courseId).orElse(null);
    }

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public void updateCourse(Course course){
        courseRepository.save(course);
    }

    public void deleteCourse(int id){
        courseRepository.deleteById(id);
    }

    public List<Course> fetchByInstructor(String instructor){
        return courseRepository.findByInstructor(instructor);
    }
    public List<Course> fetchByCategory(String category){
        return courseRepository.findByCategory(category);
    }
    public List<Course> fetchBySchedule(LocalDate from, LocalDate to){
        return courseRepository.findByStartDateGreaterThanEqualAndEndDateLessThanEqual(from, to);
    }
}
