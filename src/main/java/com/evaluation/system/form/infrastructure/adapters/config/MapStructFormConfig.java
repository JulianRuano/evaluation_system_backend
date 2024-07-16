package com.evaluation.system.form.infrastructure.adapters.config;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.evaluation.system.form.infrastructure.adapters.output.mapper.IFormHandlerMapper;

@Configuration
public class MapStructFormConfig {
    
    @Bean
    IFormHandlerMapper mapStructFormHandlerMapper() {
        return Mappers.getMapper(IFormHandlerMapper.class);
    }
}
