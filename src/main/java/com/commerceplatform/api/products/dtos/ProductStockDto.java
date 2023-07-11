package com.commerceplatform.api.products.dtos;

import com.commerceplatform.api.products.enums.ProductStockType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductStockDto {
    private Long id;
    private Long productId;
    private Long quantity;

    @JsonProperty("stock_sku")
    private String stockSku;

    @JsonProperty("stock_bar_code")
    private String stockBarCode;

    @JsonProperty("stock_type")
    private ProductStockType stockType;
    private Boolean available;
}
