package com.evaluation.system.question.infrastructure.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.evaluation.system.question.application.output.IQuestionCreateOutputPort;
import com.evaluation.system.question.domain.model.Question;
import com.evaluation.system.question.infrastructure.adapter.output.entity.QuestionEntity;
import com.evaluation.system.question.infrastructure.adapter.output.mapper.IQuestionDboMapper;
import com.evaluation.system.question.infrastructure.adapter.output.repository.IQuestionRepository;


@Component
public class QuestionCreateJpaAdapter implements IQuestionCreateOutputPort {

        @Autowired
        private  IQuestionRepository questionRepository;

        @Autowired
        private IQuestionDboMapper questionDboMapper;

        @Override
        public Question saveQuestion(Question question) {
            QuestionEntity questionEntity = questionDboMapper.toQuestionEntity(question);
            if(questionEntity == null) {
                throw new IllegalArgumentException("QuestionEntity is null");
            }
            questionEntity = questionRepository.save(questionEntity);
            return questionDboMapper.toQuestion(questionEntity);        
        }


        @Override
        public void deleteById(long questionId) {
            questionRepository.deleteById(questionId);
        }


        @Override
        public Question updateQuestion(Long id, Question question) {

            questionRepository.findByQuestionId(id);
            if (questionRepository.findByQuestionId(id) == null) {throw new IllegalArgumentException("Question not found");}

            QuestionEntity questionEntity = questionDboMapper.toQuestionEntity(question);
            if(questionEntity == null) {throw new IllegalArgumentException("QuestionEntity is null");}
            
            questionEntity = questionRepository.save(questionEntity);
            return questionDboMapper.toQuestion(questionEntity);
        }

        
}
