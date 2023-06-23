package com.commerceplatform.api.products.repositories;

import com.commerceplatform.api.products.models.ProductStockModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductStockRepository extends JpaRepository<ProductStockModel, Long> {
    Optional<ProductStockModel> findByProductId(Long productId);
}
