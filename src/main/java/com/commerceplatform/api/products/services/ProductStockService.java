package com.commerceplatform.api.products.services;

import com.commerceplatform.api.products.dtos.ProductStockDto;
import com.commerceplatform.api.products.dtos.integrations.OrderItemDto;
import com.commerceplatform.api.products.dtos.mappers.ProductStockMapper;
import com.commerceplatform.api.products.exceptions.NotFoundException;
import com.commerceplatform.api.products.models.inventory.ProductStockModel;
import com.commerceplatform.api.products.repositories.ProductRepository;
import com.commerceplatform.api.products.repositories.ProductStockRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductStockService {
    private  final ProductRepository productRepository;
    private final ProductStockRepository productStockRepository;

    public ProductStockService(ProductRepository productRepository, ProductStockRepository productStockRepository) {
        this.productRepository = productRepository;
        this.productStockRepository = productStockRepository;
    }

    public ProductStockModel create(ProductStockDto input) {
        var product = productRepository.findById(input.getProductId())
                .orElseThrow(() -> new NotFoundException("Product not found"));
        return productStockRepository.save(ProductStockMapper.toEntity(input, product));
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
