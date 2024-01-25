package com.evaluation.system.controllers.question;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public Page<Question> getQuestions(@PageableDefault(sort = { "questionId" }, direction = Sort.Direction.ASC) Pageable pageable) {
        return questionService.findAll(pageable);
    }

    @GetMapping("/{questionId}")
    public Question getQuestion(@PathVariable("questionId") long questionId) {
        return questionService.getQuestion(questionId);
    }

    @PostMapping("/")
    public Question saveQuestion(@RequestBody Question question) {
        return questionService.saveQuestion(question);
    }

    @PutMapping("/{questionId}")
    public boolean updateQuestion(@PathVariable("questionId") long questionId, @RequestBody Question question) {
        return questionService.updateQuestion(questionId, question);
    }
    
    @DeleteMapping("/{questionId}")
    public boolean deleteQuestion(@PathVariable("questionId") long questionId) {
        return questionService.deleteQuestion(questionId);
    }
    
    
}
