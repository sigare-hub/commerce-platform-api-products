package com.commerceplatform.api.stock.services;

import com.commerceplatform.api.stock.models.CategoryModel;
import com.commerceplatform.api.stock.models.ProductCategory;
import com.commerceplatform.api.stock.repositories.ProductCategoryRepository;
import com.commerceplatform.api.stock.services.rules.ProductCategoryServiceRules;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductCategoryService implements ProductCategoryServiceRules {

    private final CategoryService categoryService;
    private final ProductCategoryRepository productCategoryRepository;
    private final ProductService productService;

    public ProductCategoryService(
            CategoryService categoryService,
            ProductCategoryRepository productCategoryRepository,
            ProductService productService
    ) {
        this.categoryService = categoryService;
        this.productCategoryRepository = productCategoryRepository;
        this.productService = productService;
    }


    @Override
    @Transactional
    public void assignCategoriesToProduct(Long productId, List<Long> categoryIds) {
        var product = productService.findById(productId);

        List<CategoryModel> categories = new ArrayList<>();

        for (Long categoryId : categoryIds) {
            CategoryModel category = categoryService.findById(categoryId);
            categories.add(category);
        }

        // Remove as associações produto-categoria existentes
        List<ProductCategory> existingAssociations = productCategoryRepository.findByProduct(product);
        productCategoryRepository.deleteAll(existingAssociations);

        // Cria novas associações produto-categoria
        for (CategoryModel category : categories) {
            ProductCategory association = new ProductCategory();
            association.setProduct(product);
            association.setCategoryModel(category);
            productCategoryRepository.save(association);
        }
    }
}
