package com.evaluation.system.form.infrastructure.adapters.input.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evaluation.system.form.application.input.IFormHandlerInput;
import com.evaluation.system.form.domain.models.Form;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RequestMapping("/form")
@RestController
public class FormController {

    @Autowired
    private IFormHandlerInput formService;

    @PostMapping("/")
    public void saveForm(@RequestBody Form form){
        formService.saveForm(form);
    }
    
}
