package com.evaluation.system.services.category;

import com.evaluation.system.controllers.category.CategoryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.evaluation.system.controllers.category.CategoryRequest;

public interface ICategoryService {

    public CategoryResponse getCategory(long categoryId);

    public boolean deleteCategory(long categoryId);

    public CategoryResponse saveCategory(CategoryRequest category);

    public boolean updateCategory(long categoryId, CategoryRequest category);

    public Page<CategoryResponse> findAll(Pageable pageable);

}

  
