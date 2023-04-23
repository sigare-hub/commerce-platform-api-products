package com.commerceplatform.api.stock.models;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Table(name = "product")
@Builder
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String description;

    // TODO: Físico / Digital ou Serviço
    @Column(name = "product_type", nullable = true)
    private String productType;

    @Column(name = "sale_price")
    private Double salePrice;

    @Column(name = "purchase_price", nullable = true)
    private Double purchasePrice;

    @Column(name = "promotional_price", nullable = true)
    private Double promotionalPrice;

    @Column(nullable = true)
    private Boolean available;

    @Column(name = "stock_sku", nullable = true)
    private String stockSku;

    @Column(name = "stock_bar_code", nullable = true)
    private String stockBarCode;

    // TODO: Produto com estoque: Limitado / Ilimitado
    @Column(name = "stock_type", nullable = true)
    private String stockType;

    public ProductModel() {
    }

    public ProductModel(Long id, String name, String description, String productType, Double salePrice, Double purchasePrice, Double promotionalPrice, Boolean available, String stockSku, String stockBarCode, String stockType) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.productType = productType;
        this.salePrice = salePrice;
        this.purchasePrice = purchasePrice;
        this.promotionalPrice = promotionalPrice;
        this.available = available;
        this.stockSku = stockSku;
        this.stockBarCode = stockBarCode;
        this.stockType = stockType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Double getPromotionalPrice() {
        return promotionalPrice;
    }

    public void setPromotionalPrice(Double promotionalPrice) {
        this.promotionalPrice = promotionalPrice;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getStockSku() {
        return stockSku;
    }

    public void setStockSku(String stockSku) {
        this.stockSku = stockSku;
    }

    public String getStockBarCode() {
        return stockBarCode;
    }

    public void setStockBarCode(String stockBarCode) {
        this.stockBarCode = stockBarCode;
    }

    public String getStockType() {
        return stockType;
    }

    public void setStockType(String stockType) {
        this.stockType = stockType;
    }
}