package com.evaluation.system.question.application.input;

import com.evaluation.system.question.domain.model.Question;

public interface IQuestionCreateInputPort {
    Question saveQuestion(Question question);
    Question updateQuestion(Long id, Question question);
    void deleteById(long questionId);
}
