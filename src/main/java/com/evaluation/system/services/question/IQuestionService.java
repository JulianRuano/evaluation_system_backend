package com.evaluation.system.services.question;

import com.evaluation.system.models.Question;

public interface IQuestionService {

    public Question getQuestion(long questionId);

    public boolean deleteQuestion(long questionId);

    public Question saveQuestion(Question question);

    public boolean updateQuestion(long questionId,Question question);
}