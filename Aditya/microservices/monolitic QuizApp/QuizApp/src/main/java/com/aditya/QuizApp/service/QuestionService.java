package com.aditya.QuizApp.service;

import com.aditya.QuizApp.DAO.QuestionDAO;
import com.aditya.QuizApp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDAO questionDAO;

    public List<Question> getAllQuestions() {
        return questionDAO.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionDAO.findByCategory(category);
    }

    public String addQuestion(Question question) {
        questionDAO.save(question);
        return "Added";
    }

    public String updateQuestion(Integer id, Question question) {
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
        return "updated";
    }

    public String deleteQuestion(Integer id){
        questionDAO.deleteById(id);
        return "Deleted";
    }
}
