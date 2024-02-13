package com.evaluation.system.services.question;

import com.evaluation.system.models.Question;
import com.evaluation.system.dto.question.QuestionRequestDto;
import com.evaluation.system.dto.question.QuestionResponseDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IQuestionService {

    public QuestionResponseDto getQuestionById(long questionId);

    public boolean deleteQuestion(long questionId);

    public QuestionResponseDto saveQuestion(Question question);

    public boolean updateQuestion(long questionId,QuestionRequestDto question);

    public Page<QuestionResponseDto> findAll(Pageable pageable);

}