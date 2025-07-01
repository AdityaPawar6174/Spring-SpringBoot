package com.aditya.Admin_Rest.proxy;

import com.aditya.Admin_Rest.model.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "http://localhost:8081/course/", value = "course")
public interface AdminProxy {
    @GetMapping("/allCourses")
    public List<Course> getAllCourse();
}
