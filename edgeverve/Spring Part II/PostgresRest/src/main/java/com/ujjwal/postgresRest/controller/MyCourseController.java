package com.ujjwal.postgresRest.controller;

import com.ujjwal.postgresRest.model.CourseResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class MyCourseController {

    @GetMapping()
    public String myHome()
    {
        return "Welcome to Spring Boot Session";
    }

    @GetMapping("/welcome")
    public CourseResponse myWelcome()
    {
        CourseResponse response = new CourseResponse();
        response.setStatusCode(200);
        response.setStatusMessage("Enjoy Spring Boot");
        response.setResponseDate(java.time.LocalDate.now());
        return response;

    }




}
