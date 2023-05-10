package com.commerceplatform.api.stock.dtos.mappers;

import com.commerceplatform.api.stock.dtos.CategoryDto;
import com.commerceplatform.api.stock.dtos.ProductDto;
import com.commerceplatform.api.stock.models.CategoryModel;

public class CategoryDtoMapper {
    private CategoryDtoMapper() {
        throw new IllegalStateException("Você não pode instanciar essa classe de utilitário");
    }

    public static CategoryModel mapper(CategoryDto dto) {
        return CategoryModel.builder()
            .id(dto.getId())
            .name(dto.getName())
            .build();
    }
}
