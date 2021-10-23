package com.sparta.northwindrest.controllers;

import com.sparta.northwindrest.entities.CategoryEntity;
import com.sparta.northwindrest.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/northwind/category")
    @ResponseBody
    public List<CategoryEntity> getAllCategories(){
        return categoryRepository.findAll();
    }
}
