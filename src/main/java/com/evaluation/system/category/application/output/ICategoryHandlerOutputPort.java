package com.evaluation.system.category.application.output;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.evaluation.system.category.domain.models.Category;

public interface ICategoryHandlerOutputPort {
    public Category saveCategory(Category category);

    public boolean deleteCategory(long categoryId);

    public boolean updateCategory(long categoryId, Category category);   

    public Page<Category> getCategories(Pageable pageable);
}
