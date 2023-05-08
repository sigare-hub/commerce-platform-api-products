package com.commerceplatform.api.stock.dtos.validations;

import com.commerceplatform.api.stock.dtos.CategoryDto;
import com.commerceplatform.api.stock.dtos.ProductDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryDtoValidations extends ProductDto {
    private static final String DESCRIPTION = "description";

    public CategoryDtoValidations(CategoryDto input) {
        super.setId(input.getId());
        super.setDescription(input.getDescription());

        super.nonNull("id", input.getId());
        super.isRequired(DESCRIPTION, input.getDescription());

        if(Boolean.FALSE.equals(super.validate())) {
            Map<String, List<String>> errors = new HashMap<>(super.getAllErrors());
            super.clearErrors();
            System.out.println("error: " + errors);
            throw new IllegalArgumentException("Product is not valid");
        }
    }
}