package com.evaluation.system.question.infrastructure.adapter.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.evaluation.system.question.domain.model.Question;
import com.evaluation.system.question.infrastructure.adapter.entity.QuestionEntity;

@Mapper(componentModel = "spring")
public interface QuestionDboMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "question", source = "question")
    @Mapping(target = "answerA", source = "answerA")
    @Mapping(target = "answerB", source = "answerB")
    @Mapping(target = "answerC", source = "answerC")
    @Mapping(target = "answerD", source = "answerD")
    @Mapping(target = "correctAnswer", source = "correctAnswer")
    @Mapping(target = "level", source = "level")
    @Mapping(target = "status", source = "status")
    QuestionEntity toQuestionEntity(Question domain);

    @InheritInverseConfiguration
    Question toQuestion(QuestionEntity entity);


    
}
