package com.evaluation.system.question.domain.model;

import com.evaluation.system.category.domain.models.Category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Question {

    private Long questionId;
    private String question;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String level; 
    private Boolean status;
    private String correctAnswer;  
    
    private Category category;
}
