package com.evaluation.system.category.infrastructure.adapters.config;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.evaluation.system.category.infrastructure.adapters.input.rest.mapper.ICategoryHandlerRestMapper;
import com.evaluation.system.category.infrastructure.adapters.output.jpaAdapter.mapper.ICategoryHandlerMapper;

@Configuration
public class MapStructCategoryConfig {

    @Bean
    ICategoryHandlerRestMapper mapStructCategoryHandlerMapper() {
        return Mappers.getMapper(ICategoryHandlerRestMapper.class);
    }

    @Bean
    ICategoryHandlerMapper mapStructCategoryMapper() {
        return Mappers.getMapper(ICategoryHandlerMapper.class);
    }
    
}
