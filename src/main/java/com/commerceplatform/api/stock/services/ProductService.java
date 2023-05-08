package com.commerceplatform.api.stock.services;

import com.commerceplatform.api.stock.dtos.ProductDto;
import com.commerceplatform.api.stock.dtos.validations.ProductDtoValidations;
import com.commerceplatform.api.stock.mappers.ProductDtoMapper;
import com.commerceplatform.api.stock.models.ProductModel;
import com.commerceplatform.api.stock.repositories.ProductRepository;
import com.commerceplatform.api.stock.services.rules.ProductServiceRules;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements ProductServiceRules {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductModel create(ProductDto input) {
        ProductDtoValidations validatedInput = new ProductDtoValidations(input);
        var product = ProductDtoMapper.mapper(validatedInput);
        return productRepository.save(product);
    }

    @Override
    public List<ProductModel> findAll() {
        return productRepository.findAll();
    }
}
