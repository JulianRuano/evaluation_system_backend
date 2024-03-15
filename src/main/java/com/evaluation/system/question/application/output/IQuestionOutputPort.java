package com.evaluation.system.question.application.output;

import org.hibernate.mapping.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.evaluation.system.question.domain.model.Question;

public interface IQuestionOutputPort {

    Question save(Question question);
    Question update(Question question);
    void deleteById(long questionId);
    Question getById(long questionId);
    Page<Question> findById(Pageable pageable);
    List getAll();
}
