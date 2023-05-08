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

    public ProductModel() {
    }

    public ProductModel(Long id, String name, String description, String productType, Double salePrice, Double purchasePrice, Double promotionalPrice) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.productType = productType;
        this.salePrice = salePrice;
        this.purchasePrice = purchasePrice;
        this.promotionalPrice = promotionalPrice;
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
}