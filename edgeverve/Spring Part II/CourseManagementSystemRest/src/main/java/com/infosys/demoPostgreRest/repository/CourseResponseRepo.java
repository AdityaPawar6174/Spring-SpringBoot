package com.infosys.demoPostgreRest.repository;

import com.infosys.demoPostgreRest.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseResponseRepo extends JpaRepository<Course, Integer> {
}
