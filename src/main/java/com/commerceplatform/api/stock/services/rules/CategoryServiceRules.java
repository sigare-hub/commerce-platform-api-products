package com.commerceplatform.api.stock.services.rules;

import com.commerceplatform.api.stock.dtos.CategoryDto;
import com.commerceplatform.api.stock.models.CategoryModel;

import java.util.List;

public interface CategoryServiceRules {
    CategoryModel create(CategoryDto input);
    List<CategoryModel> findAll();
}
