package com.evaluation.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evaluation.system.models.Category;


public interface ICategoryRepository extends JpaRepository<Category, Long>{
    Category findByCategoryId(int categoryId);   
}