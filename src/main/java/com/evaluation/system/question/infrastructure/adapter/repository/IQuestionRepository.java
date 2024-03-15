package com.evaluation.system.question.infrastructure.adapter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evaluation.system.question.infrastructure.adapter.entity.QuestionEntity;


public interface IQuestionRepository extends JpaRepository<QuestionEntity, Long>{
    QuestionEntity findByQuestionId(int questionId);
}
