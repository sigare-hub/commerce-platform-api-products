package com.commerceplatform.api.products.repositories;

import com.commerceplatform.api.products.models.product.ProductImageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImageModel, Long> {
}
