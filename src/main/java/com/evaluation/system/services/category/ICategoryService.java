package com.evaluation.system.services.category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.evaluation.system.dto.category.CategoryRequestDto;
import com.evaluation.system.dto.category.CategoryResponseDto;

public interface ICategoryService {

    public CategoryResponseDto getCategoryById(long categoryId);

    public boolean deleteCategory(long categoryId);

    public CategoryResponseDto saveCategory(CategoryRequestDto category);

    public boolean updateCategory(long categoryId, CategoryRequestDto category);

    public Page<CategoryResponseDto> findAll(Pageable pageable);

}

  
