package com.commerceplatform.api.products.services.rules;

import com.commerceplatform.api.products.dtos.CategoryDto;
import com.commerceplatform.api.products.models.CategoryModel;

import java.util.List;

public interface CategoryServiceRules {
    CategoryModel create(CategoryDto input);
    CategoryModel update(CategoryDto input);
    void delete(Long id);
    CategoryModel findById(Long id);
    List<CategoryModel> findAll();
    boolean existsCategory(String name);
}
