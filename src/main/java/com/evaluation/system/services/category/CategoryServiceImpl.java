package com.evaluation.system.services.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.evaluation.system.dto.category.CategoryRequestDto;
import com.evaluation.system.dto.category.CategoryResponseDto;
import com.evaluation.system.models.Category;
import com.evaluation.system.repository.ICategoryRepository;

@Service
public class CategoryServiceImpl implements ICategoryService{

    @Autowired
    private  ICategoryRepository categoryRepository;

    @Override
    public CategoryResponseDto getCategory(long categoryId) {
        try {
            Category category = categoryRepository.findById(categoryId).get();
            if (category == null) {
                throw new RuntimeException("Category not found");        
            }
            CategoryResponseDto categoryResponse = new CategoryResponseDto();
            category.setCategoryName(categoryResponse.getName());
            category.setCategoryDescription(categoryResponse.getDescription());
    
            return categoryResponse;
        } catch (Exception e) {
            throw new RuntimeException("Failed to get category", e);
        }
    }

    @Override
    public boolean deleteCategory(long categoryId) {
        try {
            if (categoryRepository.existsById(categoryId)) {
                categoryRepository.deleteById(categoryId);
                return true;
            } else {
                return false;             
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete category", e);
        }
    }

    @Override
    public CategoryResponseDto saveCategory(CategoryRequestDto category) {
        try {
            Category newCategory = new Category();
            newCategory.setCategoryName(category.getName());
            newCategory.setCategoryDescription(category.getDescription());
            // save category
            categoryRepository.save(newCategory);
            // return response
            CategoryResponseDto categoryResponse = new CategoryResponseDto();
            categoryResponse.setName(newCategory.getCategoryName());
            categoryResponse.setDescription(newCategory.getCategoryDescription());
            return categoryResponse;
        } catch (Exception e) {
            throw new RuntimeException("Failed to save category", e);
        }
    }

    @Override
    public boolean updateCategory(long categoryId, CategoryRequestDto category) {
        try {
            Category updatedCategory = categoryRepository.findById(categoryId).get();
            if (updatedCategory == null) {
                throw new RuntimeException("Category not found");
            }
            updatedCategory.setCategoryName(category.getName());
            updatedCategory.setCategoryDescription(category.getDescription());
            categoryRepository.save(updatedCategory);
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Failed to update category", e);
        }
    }

    @Override
    public Page<CategoryResponseDto> findAll(Pageable pageable) {
        try {
            if (pageable == null) {
                throw new IllegalArgumentException("Pageable cannot be null");
            }
            
            Page<Category> categories = categoryRepository.findAll(pageable);
            return categories.map(category -> {
                CategoryResponseDto categoryResponse = new CategoryResponseDto();
                categoryResponse.setName(category.getCategoryName());
                categoryResponse.setDescription(category.getCategoryDescription());
                return categoryResponse;
            });
        } catch (Exception e) {
            throw new RuntimeException("Failed to get categories", e);
        }
    }
    
}
