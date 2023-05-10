package com.commerceplatform.api.stock.dtos;

import com.commerceplatform.api.stock.utils.Validator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDto extends Validator {
    private Long id;
    private String name;
}
