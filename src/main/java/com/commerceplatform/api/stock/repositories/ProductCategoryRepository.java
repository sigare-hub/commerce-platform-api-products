package com.commerceplatform.api.stock.repositories;

import com.commerceplatform.api.stock.models.ProductCategory;
import com.commerceplatform.api.stock.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
    List<ProductCategory> findByProduct(ProductModel product);
}