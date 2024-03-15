package com.evaluation.system.question.infrastructure.adapter.entity;

import com.evaluation.system.category.domain.models.Category;
import com.evaluation.system.question.application.dtos.QuestionRequestDto;
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
public class QuestionEntity {

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
}
