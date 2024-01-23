package com.evaluation.system.services.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluation.system.models.Question;
import com.evaluation.system.repository.IQuestionRepository;

import lombok.NonNull;


@Service
public class QuestionServiceImpl implements IQuestionService{

    @Autowired
    private  IQuestionRepository questionRepository;

    @Override
    public boolean deleteQuestion(long questionId) {
        try {
            questionRepository.deleteById(questionId);
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete question", e);
        }
    }

    @Override
    public Question saveQuestion(@NonNull Question question) {
        try {
            questionRepository.save(question);
            return question;
        } catch (Exception e) {
            throw new RuntimeException("Failed to save question", e);
        }
    }

    @Override
    public boolean updateQuestion(@NonNull Question question) {
        try {
            questionRepository.save(question);
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Failed to update question", e);
        }
    }

    
}
