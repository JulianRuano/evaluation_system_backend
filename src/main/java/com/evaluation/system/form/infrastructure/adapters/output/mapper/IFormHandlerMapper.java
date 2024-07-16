package com.evaluation.system.form.infrastructure.adapters.output.mapper;

import org.mapstruct.Mapper;

import com.evaluation.system.form.domain.models.Form;
import com.evaluation.system.form.infrastructure.adapters.output.entity.FormEntity;

@Mapper
public interface IFormHandlerMapper {

    Form toForm(FormEntity formEntity);
    
    FormEntity toFormEntity(Form form);
}
