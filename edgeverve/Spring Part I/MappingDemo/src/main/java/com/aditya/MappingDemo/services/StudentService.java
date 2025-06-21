package com.aditya.MappingDemo.services;

import com.aditya.MappingDemo.beans.Student;
import com.aditya.MappingDemo.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements StudentInterface{

    @Autowired
    StudentRepo studentRepo;

    @Override
    public void addStudent(Student student) {
        studentRepo.save(student);
    }
}
