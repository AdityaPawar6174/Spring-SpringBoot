package com.aditya.quiz_service.service;

import com.aditya.quiz_service.DAO.QuizDAO;
import com.aditya.quiz_service.feign.QuizInterface;
import com.aditya.quiz_service.model.QuestionWrapper;
import com.aditya.quiz_service.model.Quiz;
import com.aditya.quiz_service.model.QuizDTO;
import com.aditya.quiz_service.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDAO quizDAO;

    @Autowired
    QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(String category, int numQues, String title) {
        List<Integer> questions = quizInterface.getQuestionsForQuiz(category, numQues).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        quizDAO.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Quiz quiz = quizDAO.findById(id).get();
        List<Integer> questionIds = quiz.getQuestionIds();
        ResponseEntity<List<QuestionWrapper>> questionsForUsers = quizInterface.getQuestionsFromId(questionIds);
        return questionsForUsers;
   }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        ResponseEntity<Integer> score =  quizInterface.getScore(responses);
        return score;
    }

}
