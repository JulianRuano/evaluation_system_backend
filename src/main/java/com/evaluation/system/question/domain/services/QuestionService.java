package com.evaluation.system.question.domain.services;

import org.hibernate.mapping.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.evaluation.system.question.application.input.IQuestionInputPort;
import com.evaluation.system.question.application.output.IQuestionOutputPort;
import com.evaluation.system.question.domain.model.Question;

public class QuestionService implements IQuestionInputPort{

    private final IQuestionOutputPort  questionOutputPort;
     

    @Override
    public Question saveQuestion(Question question) {
        
    }

    @Override
    public Question updateQuestion(Question question) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateQuestion'");
    }

    @Override
    public void deleteById(long questionId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public Question getByIdQuestion(long questionId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByIdQuestion'");
    }

    @Override
    public Page<Question> findByIdQuestion(Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByIdQuestion'");
    }

    @Override
    public List getAllQuestion() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllQuestion'");
    }

    
    
}
