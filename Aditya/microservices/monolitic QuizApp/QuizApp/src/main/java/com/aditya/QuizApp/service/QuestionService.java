package com.aditya.QuizApp.service;

import com.aditya.QuizApp.DAO.QuestionDAO;
import com.aditya.QuizApp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDAO questionDAO;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDAO.findAll(), HttpStatus.FOUND);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try{
            return new ResponseEntity<>(questionDAO.findByCategory(category), HttpStatus.FOUND);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        try {
            questionDAO.save(question);
            return new ResponseEntity<>("Added", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> updateQuestion(Integer id, Question question) {
        try {
            Question updatedQuestion = questionDAO.findById(id).orElseThrow(() -> new RuntimeException("Id not Found"));
            updatedQuestion.setQuestionTitle(question.getQuestionTitle());
            updatedQuestion.setOption1(question.getOption1());
            updatedQuestion.setOption2(question.getOption2());
            updatedQuestion.setOption3(question.getOption3());
            updatedQuestion.setOption4(question.getOption4());
            updatedQuestion.setRightAnswer(question.getRightAnswer());
            updatedQuestion.setDifficultylevel(question.getDifficultylevel());
            updatedQuestion.setCategory(question.getCategory());
            questionDAO.save(updatedQuestion);
            return new ResponseEntity<>( "updated", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> deleteQuestion(Integer id){
        try {
            questionDAO.deleteById(id);
            return new ResponseEntity<>("Deleted", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
    }
}
