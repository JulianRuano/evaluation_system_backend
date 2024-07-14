package com.evaluation.system.form.application.output;

import com.evaluation.system.form.domain.models.Form;

public interface IFormHandlerOutput {
    Form saveForm(Form form);
    Form updateForm(Long id, Form form);
    void deleteById(long formId);  
    
}
