package com.evaluation.system.question.application.output;

import com.evaluation.system.question.domain.model.Question;

public interface IQuestionCreateOutputPort {
    Question saveQuestion(Question question);
    Question updateQuestion(Long id,Question question);
    void deleteById(long questionId);
}
