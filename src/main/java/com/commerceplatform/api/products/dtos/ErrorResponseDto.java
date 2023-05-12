package com.commerceplatform.api.products.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
public class ErrorResponseDto {
    private String message;
    private HttpStatus httpStatus;
    private Integer statusCode;
    private Object errors;
}