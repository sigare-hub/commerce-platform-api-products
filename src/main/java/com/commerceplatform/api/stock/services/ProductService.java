package com.commerceplatform.api.stock.services;

import com.commerceplatform.api.stock.dtos.ProductDto;
import com.commerceplatform.api.stock.mappers.ProductDtoMapper;
import com.commerceplatform.api.stock.models.ProductModel;
import com.commerceplatform.api.stock.repositories.ProductRepository;
import com.commerceplatform.api.stock.services.rules.ProductServiceRules;
import com.commerceplatform.api.stock.utils.Validator;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService extends Validator implements ProductServiceRules {
    private static final String NAME = "name";
    private static final String DESCRIPTION = "description";
    private static final String SALE_PRICE = "sale_price";

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        super();
        this.productRepository = productRepository;
    }

    @Override
    public ProductModel create(ProductDto input) {
        super.nonNull("id", input.getId());
        super.isRequired(NAME, input.getName());
        super.isRequired(DESCRIPTION, input.getDescription());
        super.isRequired(SALE_PRICE, String.valueOf(input.getSalePrice()));

        if(Boolean.FALSE.equals(super.validate())) {
            Map<String, List<String>> errors = new HashMap<>(super.getAllErrors());
            super.clearErrors();
            System.out.println("error: " + errors);
            return null;
        }

        var product = ProductDtoMapper.mapper(input);
        System.out.println(product);
        return productRepository.save(product);
    }

    @Override
    public List<ProductModel> findAll() {
        return null;
    }
}
