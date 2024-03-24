package com.evaluation.system.question.infrastructure.adapter.output.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import com.evaluation.system.question.domain.model.Question;
import com.evaluation.system.question.infrastructure.adapter.output.entity.QuestionEntity;

@Mapper
public interface IQuestionListMapper {

    Question toQuestion(QuestionEntity questionEntity);

    default Page<Question> toQuestionPage(Page<QuestionEntity> questionEntityPage) {
        return questionEntityPage.map(this::toQuestion);
    }
}
