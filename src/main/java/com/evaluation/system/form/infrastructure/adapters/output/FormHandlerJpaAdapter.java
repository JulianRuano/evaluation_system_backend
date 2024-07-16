package com.evaluation.system.form.infrastructure.adapters.output;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.evaluation.system.form.application.output.IFormHandlerOutput;
import com.evaluation.system.form.domain.models.Form;
import com.evaluation.system.form.infrastructure.adapters.output.entity.FormEntity;
import com.evaluation.system.form.infrastructure.adapters.output.mapper.IFormHandlerMapper;
import com.evaluation.system.form.infrastructure.adapters.output.repository.IFormRepository;

@Component
public class FormHandlerJpaAdapter  implements IFormHandlerOutput{

    @Autowired
    private IFormRepository formRepository;

    @Autowired
    private IFormHandlerMapper formHandlerMapper;

    @Override
    public Form saveForm(Form form) {
        FormEntity formEntity = formHandlerMapper.toFormEntity(form);
        formEntity = formRepository.save(formEntity);
        return formHandlerMapper.toForm(formEntity);  
    }

    @Override
    public Form updateForm(Long id, Form form) {

        Optional<FormEntity> formToUpdate = formRepository.findById(id);
        if(formToUpdate.isPresent()){
            FormEntity formEntity = formHandlerMapper.toFormEntity(form);
            formEntity.setId(id);
            formEntity = formRepository.save(formEntity);
            return formHandlerMapper.toForm(formEntity);
        }
        return null;
    }

    @Override
    public void deleteById(long formId) {
        formRepository.deleteById(formId);
    }
    
}
