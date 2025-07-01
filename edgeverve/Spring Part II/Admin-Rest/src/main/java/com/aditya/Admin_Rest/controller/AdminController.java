package com.aditya.Admin_Rest.controller;

import com.aditya.Admin_Rest.model.AdminResponse;
import com.aditya.Admin_Rest.model.Course;
import com.aditya.Admin_Rest.proxy.AdminProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin-service")
public class AdminController {

    @Autowired
    private AdminProxy adminProxy;

    @GetMapping("/admin")
    public ResponseEntity<AdminResponse> adminHome(){
        AdminResponse response = new AdminResponse();
        response.setHttpStatusCode(HttpStatus.OK);
        response.setHttpStatusMessage("Hello From the Admin Service");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/getCourseList")
    public List<Course> getCourseList() {
        return adminProxy.getAllCourse();
    }
}
