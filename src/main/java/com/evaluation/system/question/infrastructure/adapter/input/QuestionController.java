package com.evaluation.system.question.infrastructure.adapter.input;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evaluation.system.question.application.input.IQuestionCreateInputPort;
import com.evaluation.system.question.application.input.IQuestionListInputPort;
import com.evaluation.system.question.domain.model.Question;
import com.evaluation.system.question.infrastructure.adapter.input.data.request.QuestionReq;
import com.evaluation.system.question.infrastructure.adapter.input.data.response.QuestionListRes;
import com.evaluation.system.question.infrastructure.adapter.input.data.response.QuestionRes;
import com.evaluation.system.question.infrastructure.adapter.input.mapper.IQuestionCreateMapper;
import com.evaluation.system.question.infrastructure.adapter.input.mapper.IQuestionListPageMapper;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;

@RestController
@RequestMapping("/question")
@CrossOrigin(origins = "*")
public class QuestionController {

    @Autowired
    private  IQuestionCreateInputPort questionService;

    @Autowired
    private IQuestionListInputPort questionListService;

    @Autowired
    private IQuestionCreateMapper questionMapper;

    @Autowired
    private IQuestionListPageMapper questionListMapper;

     
    @GetMapping("/")
    public Page<QuestionListRes> getQuestions(@PageableDefault(sort = { "questionId" }, direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Question> questions = questionListService.findAll(pageable);
        return questionListMapper.map(questions);    
    }

    @GetMapping("/{questionId}")
    public ResponseEntity<QuestionListRes> getQuestion(@PathVariable("questionId") long questionId) {
        QuestionListRes questionResponseDto = questionListMapper.map(questionListService.getQuestionById(questionId));
        if (questionResponseDto == null) {
            return ResponseEntity.notFound().build();
        } 
        return ResponseEntity.ok(questionResponseDto);
        
    }
    

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
