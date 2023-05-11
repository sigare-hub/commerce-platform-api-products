package com.commerceplatform.api.stock.controllers;

import com.commerceplatform.api.stock.services.ProductCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-category")
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @PostMapping("/assign")
    public ResponseEntity<Void> assignCategoriesToProduct(@RequestParam Long productId, @RequestBody List<Long> categoriesId) {
        productCategoryService.assignCategoriesToProduct(productId, categoriesId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
