package com.evaluation.system.category.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluation.system.category.application.input.ICategoryHandlerInputPort;
import com.evaluation.system.category.application.output.ICategoryHandlerOutputPort;
import com.evaluation.system.category.domain.models.Category;

@Service
public class CategoryHandlerService implements ICategoryHandlerInputPort {

    @Autowired
    private ICategoryHandlerOutputPort categoryHandlerOutputPort;

    @Override
    public Category saveCategory(Category category) {
        return categoryHandlerOutputPort.saveCategory(category);
    }

    @Override
    public boolean deleteCategory(long categoryId) {
        return categoryHandlerOutputPort.deleteCategory(categoryId);
    }

    @Override
    public boolean updateCategory(long categoryId, Category category) {
        return categoryHandlerOutputPort.updateCategory(categoryId, category);
    }
    
}
