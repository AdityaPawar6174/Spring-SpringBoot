package com.infosys.ClientService_CloudRest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @GetMapping("/home")
    public String home(){
        return "please rate our services";
    }
}
