package com.evaluation.system.question.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evaluation.system.question.domain.models.Question;


public interface IQuestionRepository extends JpaRepository<Question, Long>{
    Question findByQuestionId(int questionId);
}
