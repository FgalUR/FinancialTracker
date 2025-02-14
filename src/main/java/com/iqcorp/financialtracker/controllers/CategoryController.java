package com.iqcorp.financialtracker.controllers;

import com.iqcorp.financialtracker.models.Category;
import com.iqcorp.financialtracker.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {
    final CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/categories/{id}")
    public Category getCategoryById(@PathVariable int id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/categories")
    public void createCategory(@RequestBody Category category) {
        categoryService.createCategory(category);
    }

    @PutMapping("/categories")
    public void updateCategory(@RequestBody Category category) {
        categoryService.updateCategory(category);
    }

    @DeleteMapping("/categories/{id}")
    public void deleteCategory(@PathVariable int id) {
        categoryService.deleteCategory(id);
    }
}
