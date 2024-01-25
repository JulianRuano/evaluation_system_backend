package com.evaluation.system.services.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public boolean updateQuestion(long questionId,@NonNull Question question) {
        try {
            Question questionLocal = questionRepository.findById(questionId).get();
            if (questionLocal == null) {
                throw new RuntimeException("Question not found");        
            }

            questionLocal.setQuestion(question.getQuestion());
            questionLocal.setAnswerA(question.getAnswerA());
            questionLocal.setAnswerB(question.getAnswerB());
            questionLocal.setAnswerC(question.getAnswerC());
            questionLocal.setAnswerD(question.getAnswerD());
            questionLocal.setCorrectAnswer(question.getCorrectAnswer());
            questionLocal.setLevel(question.getLevel());
            questionLocal.setStatus(question.getStatus());

            questionRepository.save(questionLocal);
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Failed to update question", e);
        }
        
    }

    @Override
    public Question getQuestion(long questionId) {
        try {
            return questionRepository.findById(questionId).get();
        } catch (Exception e) {
            throw new RuntimeException("Failed to get question", e);
        }
        
    }

    @Override
    public Page<Question> findAll(@NonNull Pageable pageable) {
        try {
            return questionRepository.findAll(pageable);
        } catch (Exception e) {
            throw new RuntimeException("Failed to get questions", e);
        }
    }

    
}
