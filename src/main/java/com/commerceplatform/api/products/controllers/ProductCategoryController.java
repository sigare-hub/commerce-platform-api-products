package com.commerceplatform.api.products.controllers;

import com.commerceplatform.api.products.dtos.ProductWithCategoriesDto;
import com.commerceplatform.api.products.dtos.inputs.AssingCategoriesToProductInput;
import com.commerceplatform.api.products.services.ProductCategoryService;
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

    @GetMapping
    public ResponseEntity<List<ProductWithCategoriesDto>> findAllProductWithCategories() {
        return ResponseEntity.status(HttpStatus.OK).body(productCategoryService.findAllProductsWithCategories());
    }

    @PostMapping("/assign")
    public ResponseEntity<Void> assignCategoriesToProduct(
            @RequestParam Long productId,
            @RequestBody AssingCategoriesToProductInput input
    ) {
        productCategoryService.assignCategoriesToProduct(productId, input.categoriesId());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
