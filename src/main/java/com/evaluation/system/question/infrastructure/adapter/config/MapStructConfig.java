package com.evaluation.system.question.infrastructure.adapter.config;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.evaluation.system.question.infrastructure.adapter.input.mapper.IQuestionCreateMapper;
import com.evaluation.system.question.infrastructure.adapter.output.mapper.IQuestionDboMapper;

@Configuration
public class MapStructConfig {
    
    @Bean
    IQuestionCreateMapper mapstructIQuestionCreateMapper(){
        return Mappers.getMapper(IQuestionCreateMapper.class);
    }

    @Bean
    IQuestionDboMapper mapstructIQuestionDboMapper(){
        return Mappers.getMapper(IQuestionDboMapper.class);
    }
}
