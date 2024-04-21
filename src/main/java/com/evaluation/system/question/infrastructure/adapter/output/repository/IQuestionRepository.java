package com.evaluation.system.question.infrastructure.adapter.output.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.evaluation.system.question.infrastructure.adapter.output.entity.QuestionEntity;

public interface IQuestionRepository extends JpaRepository<QuestionEntity, Long>{
    
}
