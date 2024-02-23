package com.evaluation.system.question.application.controllers;

import com.evaluation.system.category.domain.models.Category;
import com.evaluation.system.question.domain.models.Question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionRequestDto {
    private String question;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String level; 
    private Boolean status;
    private String correctAnswer;  
    private Category category;

    public QuestionRequestDto(Question question) {
        this.question = question.getQuestion();
        this.answerA = question.getAnswerA();
        this.answerB = question.getAnswerB();
        this.answerC = question.getAnswerC();
        this.answerD = question.getAnswerD();
        this.level = question.getLevel();
        this.status = question.getStatus();
        this.correctAnswer = question.getCorrectAnswer();
        this.category = question.getCategory();
    }


}
