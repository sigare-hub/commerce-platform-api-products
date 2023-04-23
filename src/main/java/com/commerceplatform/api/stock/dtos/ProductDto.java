package com.commerceplatform.api.stock.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private String name;
    private String description;

    @JsonProperty("video_link")
    private String videoLink;

    @JsonProperty("sales_price")
    private Double salesPrice;

    @JsonProperty("promotional_price")
    private Double promotionalPrice;

    @JsonProperty("product_type")
    private String productType;
    private Boolean available;

    @JsonProperty("stock_sku")
    private String stockSku;

    @JsonProperty("stock_bar_code")
    private String stockBarCode;

    @JsonProperty("stock_type")
    private String stockType;
}
