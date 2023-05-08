package com.commerceplatform.api.stock.dtos.mappers;

import com.commerceplatform.api.stock.dtos.ProductDto;
import com.commerceplatform.api.stock.models.ProductModel;

public class ProductDtoMapper {
    private ProductDtoMapper() {
        throw new IllegalStateException("Você não pode instanciar essa classe de utilitário");
    }

    public static ProductModel mapper(ProductDto dto) {
        return ProductModel.builder()
            .id(dto.getId())
            .name(dto.getName())
            .description(dto.getDescription())
            .productType(dto.getProductType())
            .salePrice(dto.getSalePrice())
            .purchasePrice(dto.getPurchasePrice())
            .promotionalPrice(dto.getPromotionalPrice())
            .build();
    }
}