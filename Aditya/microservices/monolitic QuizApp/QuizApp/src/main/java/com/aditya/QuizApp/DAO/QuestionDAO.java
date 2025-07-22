package com.aditya.QuizApp.DAO;

import com.aditya.QuizApp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);

    @Query(value = "Select * from Question q where q.category=:category order by random() limit :numQues", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numQues);
}
