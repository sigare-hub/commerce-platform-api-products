package com.commerceplatform.api.stock.controllers;

import com.commerceplatform.api.stock.dtos.ProductDto;
import com.commerceplatform.api.stock.models.ProductModel;
import com.commerceplatform.api.stock.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductModel> create(@RequestBody ProductDto input) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.create(input));
    }

    @GetMapping
    public ResponseEntity<List<ProductModel>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAll());
    }
}
