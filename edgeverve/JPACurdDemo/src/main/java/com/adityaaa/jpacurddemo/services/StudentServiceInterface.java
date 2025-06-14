package com.adityaaa.jpacurddemo.services;

import com.adityaaa.jpacurddemo.beans.Student;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentServiceInterface {

    public List<Student> showAllStudents();

    Student showByEmail(String SEmail);
}
