package com.evaluation.system.question.application.input;

import org.hibernate.mapping.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.evaluation.system.question.domain.model.Question;

public interface IQuestionInputPort {

    Question saveQuestion(Question question);
    Question updateQuestion(Question question);
    void deleteById(long questionId);
    Question getByIdQuestion(long questionId);
    Page<Question> findByIdQuestion(Pageable pageable);
    List getAllQuestion();
}
