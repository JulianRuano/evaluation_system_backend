package com.evaluation.system.question.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluation.system.question.application.input.IQuestionHandlerInputPort;
import com.evaluation.system.question.application.output.IQuestionCreateOutputPort;
import com.evaluation.system.question.domain.model.Question;

@Service
public class QuestionCreateService implements IQuestionHandlerInputPort {

    @Autowired
    private IQuestionCreateOutputPort outputPort;

    @Override
    public Question saveQuestion(Question question) {
        return outputPort.saveQuestion(question);
    }

    @Override
    public void deleteById(long questionId) {
        outputPort.deleteById(questionId);
    }

    @Override
    public Question updateQuestion(Long id, Question question) {
        return outputPort.updateQuestion(id, question);
    }
    
}
