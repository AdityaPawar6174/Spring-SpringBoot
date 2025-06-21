package com.adityaaa.jpacurddemo.services;

import com.adityaaa.jpacurddemo.beans.Student;
import com.adityaaa.jpacurddemo.repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements StudentServiceInterface{

    @Autowired
    StudentRepo studentRepo;

    @Override
    public List<Student> showAllStudents() {
        return studentRepo.findAllStudents();
    }

    @Override
    public Student showByEmail(String SEmail) {
        return studentRepo.findByEmail(SEmail);
    }
}
