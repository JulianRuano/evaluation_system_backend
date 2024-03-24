package com.evaluation.system.question.infrastructure.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.evaluation.system.question.application.output.IQuestionListOutputPort;
import com.evaluation.system.question.domain.model.Question;
import com.evaluation.system.question.infrastructure.adapter.output.entity.QuestionEntity;
import com.evaluation.system.question.infrastructure.adapter.output.mapper.IQuestionListMapper;
import com.evaluation.system.question.infrastructure.adapter.output.repository.IQuestionRepository;

import lombok.NonNull;

@Component
public class QuestionListJpaAdapter implements IQuestionListOutputPort {

    @Autowired
    private  IQuestionRepository questionRepository;

    @Autowired
    private IQuestionListMapper questionListMapper;

    @Override
    public Page<Question> findAll(@NonNull Pageable pageable) {
        Page<QuestionEntity> questionEntityPage = questionRepository.findAll(pageable);
        return questionListMapper.toQuestionPage(questionEntityPage);   
    }

    @Override
    public Question getQuestionById(long questionId) {
        QuestionEntity questionEntity = questionRepository.findById(questionId).get();
        return questionListMapper.toQuestion(questionEntity);
    }

    
}
