package com.evaluation.system.question.application.services;

import com.evaluation.system.question.application.controllers.QuestionRequestDto;
import com.evaluation.system.question.application.controllers.QuestionResponseDto;
import com.evaluation.system.question.domain.models.Question;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IQuestionService {

    public QuestionResponseDto getQuestionById(long questionId);

    public boolean deleteQuestion(long questionId);

    public QuestionResponseDto saveQuestion(Question question);

    public boolean updateQuestion(long questionId,QuestionRequestDto question);

    public Page<QuestionResponseDto> findAll(Pageable pageable);

}