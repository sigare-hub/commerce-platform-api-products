package com.commerceplatform.api.products.dtos;

import com.commerceplatform.api.products.models.CategoryModel;
import com.commerceplatform.api.products.models.ProductModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductWithCategoriesDto {
    private Long id;
    private String name;
    private String description;

    @JsonProperty("product_type")
    private String productType;

    @JsonProperty("sale_price")
    private Double salePrice;

    @JsonProperty("purchase_price")
    private Double purchasePrice;

    @JsonProperty("promotional_price")
    private Double promotionalPrice;

    List<CategoryModel> categories;
}
