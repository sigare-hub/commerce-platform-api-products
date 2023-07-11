package com.commerceplatform.api.products.services.rules;

import com.commerceplatform.api.products.dtos.ProductDto;
import com.commerceplatform.api.products.models.product.ProductModel;

import java.util.List;

public interface ProductServiceRules {
    ProductModel create(ProductDto input);
    ProductModel update(ProductDto input);
    void delete(Long id);
    ProductModel findById(Long id);
    List<ProductModel> findAll();
    List<ProductModel> getProductsByIds(List<Long> ids);
}
