package com.evaluation.system.category.infrastructure.adapters.output.jpaAdapter.mapper;

import org.mapstruct.Mapper;

import com.evaluation.system.category.domain.models.Category;
import com.evaluation.system.category.infrastructure.adapters.output.jpaAdapter.entity.CategoryEntity;

@Mapper
public interface ICategoryHandlerMapper {

    CategoryEntity toCategoryEntity(Category category);

    Category toCategory(CategoryEntity categoryEntity);
}
