package com.evaluation.system.form.application.input;

import com.evaluation.system.form.domain.models.Form;

public interface IFormHandlerInput {
    Form saveForm(Form form);
    Form updateForm(Long id, Form form);
    void deleteById(long formId);
    
}
