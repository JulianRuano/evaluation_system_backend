package com.evaluation.system.question.application.usecases;

import com.evaluation.system.question.application.dtos.QuestionRequestDto;
import com.evaluation.system.question.application.dtos.QuestionDto;
import com.evaluation.system.question.infrastructure.adapter.entity.QuestionEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IQuestionService {

    public QuestionDto getQuestionById(long questionId);

    public boolean deleteQuestion(long questionId);

    public QuestionDto saveQuestion(QuestionEntity question);

    public boolean updateQuestion(long questionId,QuestionRequestDto question);

    public Page<QuestionDto> findAll(Pageable pageable);

}