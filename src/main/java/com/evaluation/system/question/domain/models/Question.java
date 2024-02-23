package com.evaluation.system.question.domain.models;

import com.evaluation.system.category.domain.models.Category;
import com.evaluation.system.question.application.controllers.QuestionRequestDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    private String question;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String level; 
    private Boolean status;
    private String correctAnswer;  

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    @JsonIgnore
    public void setAll(QuestionRequestDto questionRequestDto) {
        this.question = questionRequestDto.getQuestion();
        this.answerA = questionRequestDto.getAnswerA();
        this.answerB = questionRequestDto.getAnswerB();
        this.answerC = questionRequestDto.getAnswerC();
        this.answerD = questionRequestDto.getAnswerD();
        this.level = questionRequestDto.getLevel();
        this.status = questionRequestDto.getStatus();
        this.correctAnswer = questionRequestDto.getCorrectAnswer();
        this.category = questionRequestDto.getCategory();
    }
}
