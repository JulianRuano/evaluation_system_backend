package com.evaluation.system.services.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.evaluation.system.controllers.category.CategoryRequest;
import com.evaluation.system.controllers.category.CategoryResponse;
import com.evaluation.system.models.Category;
import com.evaluation.system.repository.ICategoryRepository;


public class CategoryServiceImpl implements ICategoryService{

    @Autowired
    private  ICategoryRepository categoryRepository;

    @Override
    public CategoryResponse getCategory(long categoryId) {
        try {
            Category category = categoryRepository.findById(categoryId).get();
            if (category == null) {
                throw new RuntimeException("Category not found");        
            }
            CategoryResponse categoryResponse = new CategoryResponse();
            category.setCategoryName(categoryResponse.getName());
            category.setCategoryDescription(categoryResponse.getDescription());
    
            return categoryResponse;
        } catch (Exception e) {
            throw new RuntimeException("Failed to get category", e);
        }
    }

    @Override
    public boolean deleteCategory(long categoryId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCategory'");
    }

    @Override
    public CategoryResponse saveCategory(CategoryRequest category) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveCategory'");
    }

    @Override
    public boolean updateCategory(long categoryId, CategoryRequest category) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCategory'");
    }

    @Override
    public Page<CategoryResponse> findAll(Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
    
}
