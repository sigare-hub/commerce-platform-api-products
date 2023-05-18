package com.commerceplatform.api.products.controllers;

import com.commerceplatform.api.products.dtos.ProductDto;
import com.commerceplatform.api.products.dtos.inputs.GetProductsByIds;
import com.commerceplatform.api.products.models.ProductModel;
import com.commerceplatform.api.products.services.ProductService;
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

    @GetMapping
    public ResponseEntity<List<ProductModel>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductModel> findById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findById(id));
    }

    @GetMapping
    @RequestMapping("/by-ids")
    public ResponseEntity<List<ProductModel>> getProductsByIds(@RequestBody GetProductsByIds input) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProductsByIds(input.ids()));
    }

    @PostMapping
    public ResponseEntity<ProductModel> create(@RequestBody ProductDto input) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.create(input));
    }

    @PutMapping
    public ResponseEntity<ProductModel> update(@RequestBody ProductDto input) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.update(input));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        productService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
