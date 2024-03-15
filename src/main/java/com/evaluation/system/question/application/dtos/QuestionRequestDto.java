package com.evaluation.system.question.application.dtos;

import com.evaluation.system.category.domain.models.Category;
import com.evaluation.system.question.infrastructure.adapter.entity.QuestionEntity;

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
}
