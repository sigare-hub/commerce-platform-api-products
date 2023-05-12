package com.commerceplatform.api.products.controllers;

import com.commerceplatform.api.products.dtos.CategoryDto;
import com.commerceplatform.api.products.models.CategoryModel;
import com.commerceplatform.api.products.services.CategoryService;
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

    @GetMapping("/{id}")
    public ResponseEntity<CategoryModel> findById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.findById(id));
    }

    @PutMapping
    public ResponseEntity<CategoryModel> update(@RequestBody CategoryDto input) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.update(input));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        categoryService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}

