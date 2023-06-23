package com.commerceplatform.api.products.services;

import com.commerceplatform.api.products.dtos.integrations.OrderItemDto;
import com.commerceplatform.api.products.exceptions.NotFoundException;
import com.commerceplatform.api.products.repositories.ProductStockRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductStockService {
    private final ProductStockRepository productStockRepository;

    public ProductStockService(ProductStockRepository productStockRepository) {
        this.productStockRepository = productStockRepository;
    }

    public void updateStockQuantityByProductId(Long productId, int newQuantity) {
        // adicionar logica pra retornar lista de erros caso os produtos deem um problema de estoque
        var stock = productStockRepository.findByProductId(productId)
            .orElseThrow(() -> new NotFoundException("Product stock not found"));

        var updatedQuantity = stock.getQuantity() - newQuantity;

        if(updatedQuantity <= 0) {
            throw new IllegalArgumentException("A quantidade solicitada ultrapassa o permitido no estoque");
        }
        stock.setQuantity(updatedQuantity);

        productStockRepository.save(stock);
    }

    @Transactional
    public void updateStockBasedInOrderItems(List<OrderItemDto> orderItemDtos) {
        for(OrderItemDto orderItemDto : orderItemDtos) {
           updateStockQuantityByProductId(orderItemDto.getProductId(), orderItemDto.getQuantity());
        }
    }
}
