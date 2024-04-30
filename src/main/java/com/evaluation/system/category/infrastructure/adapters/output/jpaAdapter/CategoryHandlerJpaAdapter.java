package com.evaluation.system.category.infrastructure.adapters.output.jpaAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.evaluation.system.category.application.output.ICategoryHandlerOutputPort;
import com.evaluation.system.category.domain.models.Category;
import com.evaluation.system.category.infrastructure.adapters.output.jpaAdapter.entity.CategoryEntity;
import com.evaluation.system.category.infrastructure.adapters.output.jpaAdapter.mapper.ICategoryHandlerMapper;
import com.evaluation.system.category.infrastructure.adapters.output.jpaAdapter.repository.ICategoryRepository;

@Component
public class CategoryHandlerJpaAdapter implements ICategoryHandlerOutputPort{

    @Autowired
    private ICategoryRepository categoryRepository;

    @Autowired
    private ICategoryHandlerMapper categoryHandlerMapper;

    @Override
    public Category saveCategory(Category category) {
        CategoryEntity  categoryEntity = categoryHandlerMapper.toCategoryEntity(category);
        if (categoryEntity == null) {throw new NullPointerException("CategoryEntity is null");}

        categoryEntity = categoryRepository.save(categoryEntity);
        return categoryHandlerMapper.toCategory(categoryEntity);
    }

    @Override
    public boolean deleteCategory(long categoryId) {
        try{
            CategoryEntity categoryEntity = categoryRepository.findById(categoryId).orElse(null);
            if (categoryEntity == null) {throw new NullPointerException("CategoryEntity is null");}
            categoryRepository.delete(categoryEntity);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean updateCategory(long categoryId, Category category) {
        try{
            CategoryEntity categoryEntity = categoryRepository.findById(categoryId).orElse(null);
            if (categoryEntity == null) {throw new NullPointerException("CategoryEntity is null");}

            CategoryEntity categoryEntityUpdate = categoryHandlerMapper.toCategoryEntity(category);
            if (categoryEntityUpdate == null) {throw new NullPointerException("CategoryEntity is null");}
            
            categoryRepository.save(categoryEntityUpdate);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public Page<Category> getCategories(Pageable pageable) {
        Page<CategoryEntity> categoryEntities = categoryRepository.findAll(pageable);
        return categoryEntities.map(categoryHandlerMapper::toCategory);   
    }

    
}
