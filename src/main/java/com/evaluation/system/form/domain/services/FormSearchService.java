package com.evaluation.system.form.domain.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.evaluation.system.form.application.input.IFormSearchInput;
import com.evaluation.system.form.application.output.IFormSearchOutput;
import com.evaluation.system.form.domain.models.Form;

public class FormSearchService implements IFormSearchInput{

    @Autowired
    private IFormSearchOutput formSearchOutput;

    @Override
    public Form getFormById(long formId) {
        return formSearchOutput.getFormById(formId);
    }
    
    
}
