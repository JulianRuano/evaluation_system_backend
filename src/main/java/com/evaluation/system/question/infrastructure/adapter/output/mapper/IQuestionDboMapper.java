package com.evaluation.system.question.infrastructure.adapter.output.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import com.evaluation.system.question.domain.model.Question;
import com.evaluation.system.question.infrastructure.adapter.output.entity.QuestionEntity;

@Mapper
public interface IQuestionDboMapper {

    QuestionEntity toQuestionEntity(Question domain);

    @InheritInverseConfiguration
    Question toQuestion(QuestionEntity entity);   
}
