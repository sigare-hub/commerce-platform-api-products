package com.commerceplatform.api.products.dtos.validations;

import com.commerceplatform.api.products.dtos.CategoryDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryDtoValidations extends CategoryDto {
    private static final String DESCRIPTION = "description";

    public CategoryDtoValidations(CategoryDto input) {
        super.setId(input.getId());
        super.setName(input.getName());

        super.nonNull("id", input.getId());
        super.isRequired(DESCRIPTION, input.getName());

        if(Boolean.FALSE.equals(super.validate())) {
            Map<String, List<String>> errors = new HashMap<>(super.getAllErrors());
            super.clearErrors();
            System.out.println("error: " + errors);
            throw new IllegalArgumentException("Product is not valid");
        }
    }
}