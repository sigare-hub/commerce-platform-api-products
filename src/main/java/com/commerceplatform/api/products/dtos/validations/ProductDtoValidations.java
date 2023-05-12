package com.commerceplatform.api.products.dtos.validations;

import com.commerceplatform.api.products.dtos.ProductDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDtoValidations extends ProductDto{
    private static final String NAME = "name";
    private static final String DESCRIPTION = "description";
    private static final String SALE_PRICE = "sale_price";

    public ProductDtoValidations(ProductDto input) {
        super.setId(input.getId());
        super.setName(input.getName());
        super.setDescription(input.getDescription());
        super.setProductType(input.getProductType());
        super.setSalePrice(input.getSalePrice());
        super.setPurchasePrice(input.getPurchasePrice());
        super.setPromotionalPrice(input.getPromotionalPrice());

        super.nonNull("id", input.getId());
        super.isRequired(NAME, input.getName());
        super.isRequired(DESCRIPTION, input.getDescription());
        super.isRequired(SALE_PRICE, String.valueOf(input.getSalePrice()));

        if(Boolean.FALSE.equals(super.validate())) {
            Map<String, List<String>> errors = new HashMap<>(super.getAllErrors());
            super.clearErrors();
            System.out.println("error: " + errors);
            throw new IllegalArgumentException("Product is not valid");
        }

    }
}
