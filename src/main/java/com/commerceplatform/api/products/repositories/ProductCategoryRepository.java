package com.commerceplatform.api.products.repositories;

import com.commerceplatform.api.products.models.product.ProductCategory;
import com.commerceplatform.api.products.models.product.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
    List<ProductCategory> findByProduct(ProductModel product);
}