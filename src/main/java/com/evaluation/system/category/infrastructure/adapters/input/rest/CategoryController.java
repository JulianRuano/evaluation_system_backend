package com.evaluation.system.category.infrastructure.adapters.input.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evaluation.system.category.application.input.ICategoryHandlerInputPort;
import com.evaluation.system.category.domain.models.Category;
import com.evaluation.system.category.infrastructure.adapters.input.rest.data.request.CategoryReq;
import com.evaluation.system.category.infrastructure.adapters.input.rest.data.response.CategoryRes;
import com.evaluation.system.category.infrastructure.adapters.input.rest.mapper.ICategoryHandlerRestMapper;

import org.springframework.web.bind.annotation.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@PreAuthorize("hasRole('user_client') or hasRole('admin_client')")
public class CategoryController {

    @Autowired
    private ICategoryHandlerInputPort categoryHandlerInputPort;

    @Autowired
    private ICategoryHandlerRestMapper categoryMapper;

    @GetMapping("/")
    public Page<CategoryRes> getCategories(Pageable pageable) {
        return categoryHandlerInputPort.getCategories(pageable).map(categoryMapper::toCategoryRes);    
    }

    /* 
    @GetMapping("/{id}")
    public CategoryRes getCategory(@PathVariable("id") long id) {
        return categoryMapper.toCategoryRes(categoryHandlerInputPort.getCategory(id));
    }
    */

    @PostMapping("/")
    public CategoryRes saveCategory(@RequestBody CategoryReq categoryReq) {
        Category category = categoryMapper.toCategory(categoryReq);
        return categoryMapper.toCategoryRes(categoryHandlerInputPort.saveCategory(category));   
    }

    @PutMapping("/{id}")
    public boolean updateCategory(@PathVariable("id") long id, @RequestBody CategoryReq category) {
        return categoryHandlerInputPort.updateCategory(id, categoryMapper.toCategory(category));
    }

    @DeleteMapping("/{id}")
    public boolean deleteCategory(@PathVariable("id") long categoryId) {
        return categoryHandlerInputPort.deleteCategory(categoryId);
    }
    
}


