package com.commerceplatform.api.stock.dots;

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
    private UUID productId;
    private Long quantity;
}
