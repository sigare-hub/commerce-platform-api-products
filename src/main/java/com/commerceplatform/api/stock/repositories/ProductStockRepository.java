package com.commerceplatform.api.stock.repositories;

import com.commerceplatform.api.stock.models.ProductStockModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductStockRepository extends JpaRepository<ProductStockModel, Long> {
}
