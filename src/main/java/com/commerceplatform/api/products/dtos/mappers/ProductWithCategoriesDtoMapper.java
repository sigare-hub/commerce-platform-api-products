package com.commerceplatform.api.products.dtos.mappers;

import com.commerceplatform.api.products.dtos.ProductWithCategoriesDto;
import com.commerceplatform.api.products.models.category.CategoryModel;
import com.commerceplatform.api.products.models.product.ProductModel;

import java.util.List;

public class ProductWithCategoriesDtoMapper {
    private ProductWithCategoriesDtoMapper() {
        throw new IllegalStateException("Você não pode instanciar essa classe de utilitário");
    }

    public static ProductWithCategoriesDto mapper(ProductModel product, List<CategoryModel> categories) {
        return ProductWithCategoriesDto.builder()
            .id(product.getId())
            .name(product.getName())
            .description(product.getDescription())
            .productType(product.getProductType())
            .salePrice(product.getSalePrice())
            .purchasePrice(product.getPurchasePrice())
            .promotionalPrice(product.getPromotionalPrice())
            .categories(categories)
            .build();
    }
}