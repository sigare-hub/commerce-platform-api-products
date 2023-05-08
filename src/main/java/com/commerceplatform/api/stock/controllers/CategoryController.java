package com.commerceplatform.api.stock.controllers;

import com.commerceplatform.api.stock.dtos.CategoryDto;
import com.commerceplatform.api.stock.models.CategoryModel;
import com.commerceplatform.api.stock.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryModel> create(@RequestBody CategoryDto input) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.create(input));
    }

    @GetMapping
    public ResponseEntity<List<CategoryModel>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.findAll());
    }
}

