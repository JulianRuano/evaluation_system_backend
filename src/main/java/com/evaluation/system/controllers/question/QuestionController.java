package com.evaluation.system.controllers.question;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.evaluation.system.dto.question.QuestionRequestDto;
import com.evaluation.system.dto.question.QuestionResponseDto;
import com.evaluation.system.models.Question;
import com.evaluation.system.services.question.IQuestionService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;



@RestController
@RequestMapping("/question")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class QuestionController {

    
    private final IQuestionService questionService;

    @GetMapping("/")
    public Page<QuestionResponseDto> getQuestions(@PageableDefault(sort = { "questionId" }, direction = Sort.Direction.ASC) Pageable pageable) {
        return questionService.findAll(pageable);
    }

    @GetMapping("/{questionId}")
    public ResponseEntity<QuestionResponseDto> getQuestion(@PathVariable("questionId") long questionId) {
        QuestionResponseDto questionResponseDto = questionService.getQuestionById(questionId);
        if (questionResponseDto == null) {
            return ResponseEntity.notFound().build();
        } 
        return ResponseEntity.ok(questionResponseDto);
        
    }

    @PostMapping("/")
    public ResponseEntity<QuestionResponseDto> saveQuestion(@RequestBody Question question) {
        try {
            return ResponseEntity.ok(questionService.saveQuestion(question));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{questionId}")
    public ResponseEntity<?> updateQuestion(@PathVariable("questionId") long questionId, @RequestBody QuestionRequestDto question) {
        if (questionService.updateQuestion(questionId, question)) {    
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }    
    }
    
    @DeleteMapping("/{questionId}")
    public ResponseEntity<?> deleteQuestion(@PathVariable("questionId") long questionId) {
        if (questionService.deleteQuestion(questionId)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }      
    }
    
    
}
