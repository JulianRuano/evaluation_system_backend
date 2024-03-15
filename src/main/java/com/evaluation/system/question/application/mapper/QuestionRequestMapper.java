package com.evaluation.system.question.application.mapper;

import com.evaluation.system.question.application.dtos.QuestionRequestDto;
import com.evaluation.system.question.domain.model.Question;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionRequestMapper {

    Question toQuestion(QuestionRequestDto questionRequestDto);
}
