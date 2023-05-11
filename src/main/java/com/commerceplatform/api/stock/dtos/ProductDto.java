package com.commerceplatform.api.stock.dtos;

import com.commerceplatform.api.stock.models.CategoryModel;
import com.commerceplatform.api.stock.utils.Validator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto extends Validator {
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

    private List<CategoryDto> categories;
 }
