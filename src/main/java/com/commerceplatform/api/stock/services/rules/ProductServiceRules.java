package com.commerceplatform.api.stock.services.rules;

import com.commerceplatform.api.stock.dtos.ProductDto;
import com.commerceplatform.api.stock.models.ProductModel;

import java.util.List;

public interface ProductServiceRules {
    ProductModel create(ProductDto input);
    ProductModel update(ProductDto input);
    void delete(Long id);
    ProductModel findById(Long id);
    List<ProductModel> findAll();
}
