package com.aditya.quiz_service.model;

import lombok.Data;

@Data
public class QuestionWrapper {
    private Integer id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    public QuestionWrapper(Integer id, String option4, String option1, String questionTitle, String option2, String option3) {
        this.id = id;
        this.option4 = option4;
        this.option1 = option1;
        this.questionTitle = questionTitle;
        this.option2 = option2;
        this.option3 = option3;
    }
}
