package com.commerceplatform.api.stock.dtos.validations;

import com.commerceplatform.api.stock.dtos.ProductDto;
import com.commerceplatform.api.stock.utils.Validator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDtoValidations extends ProductDto{
    private static final String NAME = "name";
    private static final String DESCRIPTION = "description";
    private static final String SALE_PRICE = "sale_price";

    private Validator validator;

    public ProductDtoValidations(ProductDto input) {
        super.setId(input.getId());
        super.setName(input.getName());
        super.setDescription(input.getDescription());
        super.setProductType(input.getProductType());
        super.setSalePrice(input.getSalePrice());
        super.setPurchasePrice(input.getPurchasePrice());
        super.setPromotionalPrice(input.getPromotionalPrice());

        validator.nonNull("id", input.getId());
        validator.isRequired(NAME, input.getName());
        validator.isRequired(DESCRIPTION, input.getDescription());
        validator.isRequired(SALE_PRICE, String.valueOf(input.getSalePrice()));

        if(Boolean.FALSE.equals(validator.validate())) {
            Map<String, List<String>> errors = new HashMap<>(validator.getAllErrors());
            validator.clearErrors();
            System.out.println("error: " + errors);
            throw new IllegalArgumentException("Product is not valid");
        }
    }
}
