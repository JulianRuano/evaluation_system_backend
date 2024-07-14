package com.evaluation.system.form.application.input;

import com.evaluation.system.form.domain.models.Form;

public interface IFormSearchInput {
    Form getFormById(long formId);  
}
