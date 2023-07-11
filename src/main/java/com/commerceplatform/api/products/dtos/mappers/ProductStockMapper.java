package com.commerceplatform.api.products.dtos.mappers;

import com.commerceplatform.api.products.dtos.ProductStockDto;
import com.commerceplatform.api.products.models.ProductModel;
import com.commerceplatform.api.products.models.ProductStockModel;

public class ProductStockMapper {
    private ProductStockMapper() {
        throw new IllegalStateException("Você não pode instanciar essa classe de utilitário");
    }

    public static ProductStockModel toEntity(ProductStockDto dto, ProductModel product) {
        return ProductStockModel.builder()
            .id(dto.getId())
            .available(dto.getAvailable())
            .productModel(product)
            .stockSku(dto.getStockSku())
            .stockType(String.valueOf(dto.getStockType()))
            .quantity(dto.getQuantity())
            .stockBarCode(dto.getStockBarCode())
            .build();
    }
// WIP
//    public static ProductStockDto toDto(ProductStockModel productStockModel) {
//        return ProductStockDto.builder()
//                .productId(productStockModel.getId())
//                .available(productStockModel.getAvailable())
//                .id(productStockModel.getId())
//                .stockType(productStockModel.getStockType())
//            .build();
//    }
}

