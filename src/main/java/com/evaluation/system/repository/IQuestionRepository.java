package com.evaluation.system.repository;

import com.evaluation.system.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IQuestionRepository extends JpaRepository<Question, Long>{
    Question findByQuestionId(int questionId);
}
