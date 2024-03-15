package com.evaluation.system.question.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.evaluation.system.question.application.dtos.QuestionRequestDto;
import com.evaluation.system.question.application.input.IQuestionInputPort;
import com.evaluation.system.question.application.dtos.QuestionDto;
import com.evaluation.system.question.application.usecases.IQuestionService;
import com.evaluation.system.question.infrastructure.adapter.entity.QuestionEntity;

import lombok.NonNull;


@Service
public class QuestionServiceImpl implements IQuestionService{

    @Autowired
    private  IQuestionInputPort questionPersistencePort;

    @Override
    public boolean deleteQuestion(long questionId) {
        try {
            questionPersistencePort.deleteById(questionId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public QuestionDto saveQuestion(@NonNull QuestionEntity question) {
        try {
            questionPersistencePort.save(question);
            QuestionDto questionResponse = new QuestionDto();
            questionResponse.setQuestionId(question.getQuestionId());
            questionResponse.setQuestion(question.getQuestion());
            questionResponse.setAnswerA(question.getAnswerA());
            questionResponse.setAnswerB(question.getAnswerB());
            questionResponse.setAnswerC(question.getAnswerC());
            questionResponse.setAnswerD(question.getAnswerD());
            questionResponse.setCorrectAnswer(question.getCorrectAnswer());
            questionResponse.setLevel(question.getLevel());
            questionResponse.setStatus(question.getStatus());
            return questionResponse;         
        } catch (Exception e) {
            throw new RuntimeException("Failed to save question", e);
        }
    }

    @Override
    public boolean updateQuestion(long questionId,@NonNull QuestionRequestDto question) {
        try {
            QuestionEntity questionLocal = questionPersistencePort.findById(questionId).get();
            if (questionLocal == null) {
                throw new RuntimeException("Question not found");        
            }
            questionLocal.setAll(question);
            questionPersistencePort.save(questionLocal);
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }

    @Override
    public QuestionDto getQuestionById(long questionId) {
        try {
            QuestionEntity question = questionPersistencePort.findById(questionId).get();
            if (question == null) {
                throw new RuntimeException("Question not found");
            }
            QuestionDto questionResponse = new QuestionDto();
            questionResponse.setQuestionId(question.getQuestionId());
            questionResponse.setQuestion(question.getQuestion());
            questionResponse.setAnswerA(question.getAnswerA());
            questionResponse.setAnswerB(question.getAnswerB());
            questionResponse.setAnswerC(question.getAnswerC());
            questionResponse.setAnswerD(question.getAnswerD());
            questionResponse.setCorrectAnswer(question.getCorrectAnswer());
            questionResponse.setLevel(question.getLevel());
            questionResponse.setStatus(question.getStatus());
            return questionResponse;         
        } catch (Exception e) {
            throw new RuntimeException("Failed to get question", e);
        }
        
    }

    @Override
    public Page<QuestionDto> findAll(@NonNull Pageable pageable) {
        try {
            Page<QuestionDto> questionResponse = questionPersistencePort.findAll(pageable);
            return questionResponse.map(question -> {
                QuestionDto questionResponseDto = new QuestionDto();
                questionResponseDto.setQuestionId(question.getQuestionId());
                questionResponseDto.setQuestion(question.getQuestion());
                questionResponseDto.setAnswerA(question.getAnswerA());
                questionResponseDto.setAnswerB(question.getAnswerB());
                questionResponseDto.setAnswerC(question.getAnswerC());
                questionResponseDto.setAnswerD(question.getAnswerD());
                questionResponseDto.setCorrectAnswer(question.getCorrectAnswer());
                questionResponseDto.setLevel(question.getLevel());
                questionResponseDto.setStatus(question.getStatus());
                return questionResponseDto;
            });        
        } catch (Exception e) {
            throw new RuntimeException("Failed to get questions", e);
        }
    }

    
}
