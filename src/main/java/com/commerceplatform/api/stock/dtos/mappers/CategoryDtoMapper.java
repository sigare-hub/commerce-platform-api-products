package com.commerceplatform.api.stock.dtos.mappers;

import com.commerceplatform.api.stock.dtos.ProductDto;
import com.commerceplatform.api.stock.models.CategoryModel;

public class CategoryDtoMapper {
    private CategoryDtoMapper() {
        throw new IllegalStateException("Você não pode instanciar essa classe de utilitário");
    }

    public static CategoryModel mapper(ProductDto dto) {
        return CategoryModel.builder()
            .id(dto.getId())
            .description(dto.getDescription())
            .build();
    }
}
