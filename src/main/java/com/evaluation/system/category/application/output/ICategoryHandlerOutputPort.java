package com.evaluation.system.category.application.output;

import com.evaluation.system.category.domain.models.Category;

public interface ICategoryHandlerOutputPort {
    public Category saveCategory(Category category);

    public boolean deleteCategory(long categoryId);

    public boolean updateCategory(long categoryId, Category category);   
}
