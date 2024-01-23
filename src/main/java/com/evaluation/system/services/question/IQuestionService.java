package com.evaluation.system.services.question;

import com.evaluation.system.models.Question;

public interface IQuestionService {

    public boolean deleteQuestion(long questionId);

    public Question saveQuestion(Question question);

    public boolean updateQuestion(Question question);
}