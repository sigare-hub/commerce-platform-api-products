package com.commerceplatform.api.products.services;

import com.commerceplatform.api.products.dtos.ProductDto;
import com.commerceplatform.api.products.dtos.validations.ProductDtoValidations;
import com.commerceplatform.api.products.dtos.mappers.ProductDtoMapper;
import com.commerceplatform.api.products.models.ProductModel;
import com.commerceplatform.api.products.repositories.ProductRepository;
import com.commerceplatform.api.products.services.rules.ProductServiceRules;
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
    public ProductModel update(ProductDto input) {
        findById(input.getId());
        return productRepository.save(ProductDtoMapper.mapper(input));
    }

    @Override
    public void delete(Long id) {
        findById(id);
        productRepository.deleteById(id);
    }

    @Override
    public ProductModel findById(Long id) {
        return productRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public List<ProductModel> findAll() {
        return productRepository.findAll();
    }
}
