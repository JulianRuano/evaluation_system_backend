package com.evaluation.system.category.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evaluation.system.category.domain.models.Category;


public interface ICategoryRepository extends JpaRepository<Category, Long>{
    Category findByCategoryId(int categoryId);   
}