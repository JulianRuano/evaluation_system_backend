package com.evaluation.system.question.infrastructure.adapter.input.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import com.evaluation.system.question.domain.model.Question;
import com.evaluation.system.question.infrastructure.adapter.input.data.response.QuestionListRes;

@Mapper
public interface IQuestionListPageMapper {

    Question toQuestion(QuestionListRes questionListRes);

    QuestionListRes map(Question question);

    default Page<QuestionListRes> map(Page<Question> questions) {
        return questions.map(this::map);
    }
    
}
