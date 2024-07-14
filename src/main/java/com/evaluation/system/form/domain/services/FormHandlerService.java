package com.evaluation.system.form.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluation.system.form.application.input.IFormHandlerInput;
import com.evaluation.system.form.application.output.IFormHandlerOutput;
import com.evaluation.system.form.domain.models.Form;

@Service
public class FormHandlerService implements IFormHandlerInput{

    @Autowired
    private IFormHandlerOutput formHandlerOutput;

    @Override
    public Form saveForm(Form form) {
        return formHandlerOutput.saveForm(form);
    }

    @Override
    public Form updateForm(Long id, Form form) {
        return formHandlerOutput.updateForm(id, form);
    }

    @Override
    public void deleteById(long formId) {
        formHandlerOutput.deleteById(formId);
    }
    
    
}
