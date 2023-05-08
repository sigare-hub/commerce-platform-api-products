package com.commerceplatform.api.stock.services;

import com.commerceplatform.api.stock.dtos.CategoryDto;
import com.commerceplatform.api.stock.dtos.mappers.CategoryDtoMapper;
import com.commerceplatform.api.stock.dtos.validations.CategoryDtoValidations;
import com.commerceplatform.api.stock.models.CategoryModel;
import com.commerceplatform.api.stock.repositories.CategoryRepository;
import com.commerceplatform.api.stock.services.rules.CategoryServiceRules;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements CategoryServiceRules {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryModel create(CategoryDto input) {
        CategoryDtoValidations validatedInput = new CategoryDtoValidations(input);
        var product = CategoryDtoMapper.mapper(validatedInput);
        return categoryRepository.save(product);
    }

    @Override
    public List<CategoryModel> findAll() {
        return categoryRepository.findAll();
    }
}
