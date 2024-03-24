package com.evaluation.system.question.application.input;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.evaluation.system.question.domain.model.Question;

public interface IQuestionSearchInputPort {

    public Page<Question> findAll(Pageable pageable);

    public Question getQuestionById(long questionId);
}
