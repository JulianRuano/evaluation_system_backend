package com.evaluation.system.question.infrastructure.adapter.input;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evaluation.system.question.application.input.IQuestionCreateInputPort;
import com.evaluation.system.question.domain.model.Question;
import com.evaluation.system.question.infrastructure.adapter.input.data.request.QuestionReq;
import com.evaluation.system.question.infrastructure.adapter.input.data.response.QuestionRes;
import com.evaluation.system.question.infrastructure.adapter.input.mapper.IQuestionCreateMapper;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/question")
@CrossOrigin(origins = "*")
public class QuestionController {

    @Autowired
    private  IQuestionCreateInputPort questionService;

    @Autowired
    private IQuestionCreateMapper questionMapper;


    /* 
    @GetMapping("/")
    public Page<QuestionDto> getQuestions(@PageableDefault(sort = { "questionId" }, direction = Sort.Direction.ASC) Pageable pageable) {
        return questionService.findAll(pageable);
    }

    @GetMapping("/{questionId}")
    public ResponseEntity<QuestionDto> getQuestion(@PathVariable("questionId") long questionId) {
        QuestionDto questionResponseDto = questionService.getQuestionById(questionId);
        if (questionResponseDto == null) {
            return ResponseEntity.notFound().build();
        } 
        return ResponseEntity.ok(questionResponseDto);
        
    }
    */

    @PostMapping("/")
    public ResponseEntity<QuestionRes> saveQuestion(@RequestBody QuestionReq question) {
        try {
            Question questionEntity = questionService.saveQuestion(questionMapper.toQuestion(question));
            return ResponseEntity.ok(questionMapper.toQuestionRes(questionEntity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{questionId}")
    public ResponseEntity<?> updateQuestion(@PathVariable("questionId") long questionId, @RequestBody QuestionReq question) {
        Question questionEntity = questionMapper.toQuestion(question);
        try {
            questionService.updateQuestion(questionId, questionEntity);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

          
    }
    
    @DeleteMapping("/{questionId}")
    public ResponseEntity<?> deleteQuestion(@PathVariable("questionId") long questionId) {
        try {
            questionService.deleteById(questionId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }   
    }
    
    
}
