package com.evaluation.system.question.application.mapper;

import org.mapstruct.Mapper;

import com.evaluation.system.question.application.dtos.QuestionDto;
import com.evaluation.system.question.domain.model.Question;


@Mapper(componentModel = "spring")
public interface QuestionDtoMapper {

    QuestionDto toQuestionDto(Question question);

}