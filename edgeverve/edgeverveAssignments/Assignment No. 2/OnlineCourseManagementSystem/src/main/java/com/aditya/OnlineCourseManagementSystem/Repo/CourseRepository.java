package com.aditya.OnlineCourseManagementSystem.Repo;

import com.aditya.OnlineCourseManagementSystem.Beans.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {

    public List<Course> findByCategory(String category);

    public List<Course> findByInstructor(String instructor);

    public List<Course> findByStartDateGreaterThanEqualAndEndDateLessThanEqual(LocalDate startDate, LocalDate endDate);
}
