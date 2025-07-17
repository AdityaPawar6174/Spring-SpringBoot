package com.infosys.spring_actuator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sampler")
public class SamplerController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello Welcome";
    }
}
