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
        var category = CategoryDtoMapper.mapper(validatedInput);

        if(Boolean.TRUE.equals(existsCategory(category.getName()))) {
            throw new RuntimeException("Bad request exception: category already exist");
        }

        return categoryRepository.save(category);
    }

    @Override
    public CategoryModel update(CategoryDto input) {
        findById(input.getId());
        return categoryRepository.save(CategoryDtoMapper.mapper(input));
    }

    @Override
    public void delete(Long id) {
        findById(id);
        categoryRepository.deleteById(id);
    }

    @Override
    public CategoryModel findById(Long id) {
        return categoryRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public List<CategoryModel> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public boolean existsCategory(String name) {
        return categoryRepository.existsByNameIgnoreCaseAndWithoutAccent(name);
    }
}
