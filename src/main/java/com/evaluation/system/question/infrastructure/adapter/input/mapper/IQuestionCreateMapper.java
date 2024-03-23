package com.evaluation.system.question.infrastructure.adapter.input.mapper;

import org.mapstruct.Mapper;

import com.evaluation.system.question.domain.model.Question;
import com.evaluation.system.question.infrastructure.adapter.input.data.request.QuestionReq;
import com.evaluation.system.question.infrastructure.adapter.input.data.response.QuestionRes;

@Mapper
public interface IQuestionCreateMapper {

    Question toQuestion(QuestionReq questionEntity);

    QuestionRes toQuestionRes(Question question);
}
