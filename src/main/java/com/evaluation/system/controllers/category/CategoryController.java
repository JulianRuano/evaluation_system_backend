package com.evaluation.system.controllers.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.evaluation.system.services.category.ICategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/")
    public Page<CategoryResponse> getCategories(Pageable pageable) {
        return categoryService.findAll(pageable);
    }

    @GetMapping("/{categoryId}")
    public CategoryResponse getCategory(long categoryId) {
        return categoryService.getCategory(categoryId);
    }

    @PostMapping("/")
    public CategoryResponse saveCategory(@RequestBody CategoryRequest category) {
        return categoryService.saveCategory(category);
    }

    @PutMapping("/{categoryId}")
    public boolean updateCategory(@PathVariable("categoryId") long categoryId, @RequestBody CategoryRequest category) {
        return categoryService.updateCategory(categoryId, category);
    }

    @DeleteMapping("/{categoryId}")
    public boolean deleteCategory(@PathVariable("categoryId") long categoryId) {
        return categoryService.deleteCategory(categoryId);
    }
    
}

