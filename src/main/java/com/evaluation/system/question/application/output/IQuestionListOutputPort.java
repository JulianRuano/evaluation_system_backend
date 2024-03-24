package com.evaluation.system.question.application.output;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.evaluation.system.question.domain.model.Question;

public interface IQuestionListOutputPort {

    public Page<Question> findAll(Pageable pageable);

    public Question getQuestionById(long questionId);
}
