package com.evaluation.system.category.infrastructure.adapters.input.rest.mapper;

import org.mapstruct.Mapper;

import com.evaluation.system.category.domain.models.Category;
import com.evaluation.system.category.infrastructure.adapters.input.rest.data.request.CategoryReq;
import com.evaluation.system.category.infrastructure.adapters.input.rest.data.response.CategoryRes;

@Mapper
public interface ICategoryHandlerRestMapper {
    CategoryReq toCategoryReq(Category category);

    CategoryRes toCategoryRes(Category category);

    Category toCategory(CategoryReq categoryReq);
}
