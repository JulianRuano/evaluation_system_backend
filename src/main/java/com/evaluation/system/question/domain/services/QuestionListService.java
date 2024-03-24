package com.evaluation.system.question.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.evaluation.system.question.application.input.IQuestionSearchInputPort;
import com.evaluation.system.question.application.output.IQuestionListOutputPort;
import com.evaluation.system.question.domain.model.Question;

@Service
public class QuestionListService implements IQuestionSearchInputPort{

    @Autowired
    private IQuestionListOutputPort outputPort;

    @Override
    public Page<Question> findAll(Pageable pageable) {
        return outputPort.findAll(pageable);
    }

    @Override
    public Question getQuestionById(long questionId) {
        return outputPort.getQuestionById(questionId);
    }
    
}
