package com.aditya.Admin_Rest.proxy;

import com.aditya.Admin_Rest.model.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(url = "http://localhost:8081/course/", value = "course")
public interface AdminProxy {
    @GetMapping("/AllCourse")
    public List<Course> getAllCourse();

    @GetMapping("/searchCourse")
    public Course searchCourse(@RequestParam int courseId);

}
