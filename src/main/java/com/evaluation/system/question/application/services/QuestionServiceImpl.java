package com.evaluation.system.question.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.evaluation.system.question.application.controllers.QuestionRequestDto;
import com.evaluation.system.question.application.controllers.QuestionResponseDto;
import com.evaluation.system.question.domain.models.Question;
import com.evaluation.system.question.domain.repository.IQuestionRepository;

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
            return false;
        }
    }

    @Override
    public QuestionResponseDto saveQuestion(@NonNull Question question) {
        try {
            questionRepository.save(question);
            QuestionResponseDto questionResponse = new QuestionResponseDto();
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
            Question questionLocal = questionRepository.findById(questionId).get();
            if (questionLocal == null) {
                throw new RuntimeException("Question not found");        
            }
            questionLocal.setAll(question);
            questionRepository.save(questionLocal);
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }

    @Override
    public QuestionResponseDto getQuestionById(long questionId) {
        try {
            Question question = questionRepository.findById(questionId).get();
            if (question == null) {
                throw new RuntimeException("Question not found");
            }
            QuestionResponseDto questionResponse = new QuestionResponseDto();
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
    public Page<QuestionResponseDto> findAll(@NonNull Pageable pageable) {
        try {
            Page<Question> questionResponse = questionRepository.findAll(pageable);
            return questionResponse.map(question -> {
                QuestionResponseDto questionResponseDto = new QuestionResponseDto();
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
