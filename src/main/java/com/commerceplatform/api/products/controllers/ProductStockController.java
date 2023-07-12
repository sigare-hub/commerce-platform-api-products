package com.commerceplatform.api.products.controllers;

import com.commerceplatform.api.products.dtos.ProductStockDto;
import com.commerceplatform.api.products.models.inventory.ProductStockModel;
import com.commerceplatform.api.products.services.ProductStockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class ProductStockController {
    private final ProductStockService productStockService;

    public ProductStockController(ProductStockService productStockService) {
        this.productStockService = productStockService;
    }

    @PostMapping
    public ResponseEntity<ProductStockModel> create(@RequestBody ProductStockDto input) {
        return ResponseEntity.status(HttpStatus.OK).body(productStockService.create(input));
    }
}