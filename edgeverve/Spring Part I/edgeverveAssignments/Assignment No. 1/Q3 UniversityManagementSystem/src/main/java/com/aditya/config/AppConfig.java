package com.aditya.config;

import com.aditya.beans.Course;
import com.aditya.beans.Student;
import com.aditya.beans.UniversityService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.aditya"})
public class AppConfig {

    @Bean
    public Student student(){
        return new Student();
    }

    @Bean
    public Course course(){
        return new Course();
    }

    @Bean
    public UniversityService universityService(){
        return new UniversityService();
    }
}
