package com.evaluation.system.question.infrastructure.adapter;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.evaluation.system.question.application.input.IQuestionInputPort;
import com.evaluation.system.question.domain.model.Question;
import com.evaluation.system.question.infrastructure.adapter.entity.QuestionEntity;
import com.evaluation.system.question.infrastructure.adapter.repository.IQuestionRepository;

import io.micrometer.common.lang.NonNull;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class QuestionJpaAdapter implements IQuestionInputPort {

        @Autowired
        private  IQuestionRepository questionRepository;

        @Override
        public Question save(Question question) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'save'");
        }

        @Override
        public Question update(Question question) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'update'");
        }

        @Override
        public void deleteById(long questionId) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
        }

        @Override
        public Question getById(long questionId) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getById'");
        }

        @Override
        public Page<Question> findById(Pageable pageable) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'findById'");
        }

        @Override
        public List getAll() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getAll'");
        }

    
}
