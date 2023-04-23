package com.commerceplatform.api.stock.repositories;

import com.commerceplatform.api.stock.models.ProductImageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImageModel, Long> {
}
