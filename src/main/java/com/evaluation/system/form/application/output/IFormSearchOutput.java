package com.evaluation.system.form.application.output;

import com.evaluation.system.form.domain.models.Form;

public interface IFormSearchOutput {
    Form getFormById(long formId);
}
