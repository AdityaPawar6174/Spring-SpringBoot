package com.infosys.demoPostgreRest.controller;

import com.infosys.demoPostgreRest.model.Course;
import com.infosys.demoPostgreRest.model.CourseResponse;
import com.infosys.demoPostgreRest.service.impl.CourseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/course")
@Slf4j
public class MyCourseController {
    CourseServiceImpl courseService;
    public MyCourseController(CourseServiceImpl courseService){
        this.courseService = courseService;
    }

    @GetMapping("/home")
    public String Home(){
        return "Welcome to Home";
    }

    @GetMapping("/welcome")
    public CourseResponse myWelcome(){
        CourseResponse response = new CourseResponse();
        response.setStatusCode(1223);
        response.setStatusMsg("Enjoy Learning with Infy");
        response.setResponseDate(java.time.LocalDate.now());
        return response;
    }

    @PostMapping("/addCourse")
    public CourseResponse addCourse(@RequestBody Course course){
        courseService.createCourse(course);
        CourseResponse courseResponse= new CourseResponse();
        courseResponse.setStatusCode(200);
        courseResponse.setStatusMsg("Course added successfully");
        courseResponse.setResponseDate(LocalDate.now());
        return courseResponse;
    }

    @PostMapping("/newCourse")
    public ResponseEntity<CourseResponse> addNewCourse(@RequestBody Course course){
        courseService.createCourse(course);
        CourseResponse courseResponse= new CourseResponse();
        courseResponse.setStatusCode(200);
        courseResponse.setStatusMsg("Course added successfully");
        courseResponse.setResponseDate(LocalDate.now());
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("My Header" , "RestPostrgrApp").body(courseResponse);
    }


    @GetMapping("/searchCourse")
    public Course searchCourse(@RequestParam int courseId){
        return courseService.getCourse(courseId);
    }

    @GetMapping("/")
    public CourseResponse homepage(@RequestHeader("User-Agent") String headeragent) {
        log.info(String.format("Header user agent making request %s", headeragent));

        CourseResponse response = new CourseResponse();
        response.setStatusCode(200);
        response.setStatusMsg("Course Added Successfully");
        response.setResponseDate(LocalDate.now());

        return response;
    }

    @GetMapping("/AllCourse")
    public List<Course> displayAllCourse (){
        return courseService.getAllCourse();
    }

//    @PutMapping("/updatecourse")
//    public CourseResponse

//    @PutMapping("/updateCourse")
//    public ResponseEntity<CourseResponse> updateCourse(@RequestBody Course course) {
//        CourseResponse response = new CourseResponse();
//        response.setStatusCode(200);
//        response.setStatusMsg(courseService.updateCourse(course));
//        response.setResponseDate(java.time.LocalDate.now());
//        return ResponseEntity.ok(response);
//    }

    @PutMapping("/updateCourse")
    public ResponseEntity<CourseResponse> updateCourse(@RequestParam int courseId, @RequestParam String courseName, @RequestParam int duration) {

        Course course = new Course();
        course.setCourseId(courseId);
        course.setCourseName(courseName);
        course.setDuration(duration);

        CourseResponse response = new CourseResponse();
        response.setStatusCode(200);
        response.setStatusMsg(courseService.updateCourse(course));
        response.setResponseDate(java.time.LocalDate.now());

        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/deleteCourse")
    public ResponseEntity<CourseResponse> deleteCourseById(@RequestParam int courseId) {
        CourseResponse response = new CourseResponse();
        response.setStatusCode(200);
        response.setStatusMsg(courseService.deleteCourse(courseId));
        response.setResponseDate(java.time.LocalDate.now());
        return ResponseEntity.ok(response);
    }
}
