package com.commerceplatform.api.products.services;

import com.commerceplatform.api.products.dtos.ProductWithCategoriesDto;
import com.commerceplatform.api.products.dtos.mappers.ProductWithCategoriesDtoMapper;
import com.commerceplatform.api.products.models.CategoryModel;
import com.commerceplatform.api.products.models.ProductCategory;
import com.commerceplatform.api.products.models.ProductModel;
import com.commerceplatform.api.products.repositories.ProductCategoryRepository;
import com.commerceplatform.api.products.services.rules.ProductCategoryServiceRules;
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

    @Transactional
    public List<ProductWithCategoriesDto> findAllProductsWithCategories() {
        List<ProductModel> products = productService.findAll();
        List<ProductWithCategoriesDto> productWithCategories = new ArrayList<>();

        for (ProductModel product : products) {
            List<CategoryModel> categories = productCategoryRepository.findByProduct(product)
                .stream()
                .map(ProductCategory::getCategoryModel).toList();

            var productWithCategoriesDto = ProductWithCategoriesDtoMapper.mapper(product, categories);
            productWithCategories.add(productWithCategoriesDto);
        }
        return productWithCategories;
    }
}
