package com.adityaaa.jpacurddemo.repos;

import com.adityaaa.jpacurddemo.beans.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {

    List<Student> findAllStudents();

    Student findByEmail(@Param("email") String SEmail);
}
