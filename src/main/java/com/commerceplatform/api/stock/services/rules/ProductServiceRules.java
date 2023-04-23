package com.commerceplatform.api.stock.services.rules;

import com.commerceplatform.api.stock.dtos.ProductDto;
import com.commerceplatform.api.stock.models.ProductModel;

import java.util.List;

public interface ProductServiceRules {
    ProductModel create(ProductDto input);
    List<ProductModel> findAll();
}
