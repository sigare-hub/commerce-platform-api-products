package com.commerceplatform.api.products.dtos;

import com.commerceplatform.api.products.utils.Validator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
 }
