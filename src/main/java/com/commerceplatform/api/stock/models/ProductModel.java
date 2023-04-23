package com.commerceplatform.api.stock.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "product")
public class ProductModel {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    private String name;
    private String description;

    @Column(name = "video_link")
    private String videoLink;

    @Column(name = "sales_price")
    private Double salesPrice;

    @Column(name = "promotional_price")
    private Double promotionalPrice;

    // TODO: Físico / Digital ou Serviço
    @Column(name = "product_type")
    private String productType;
    private Boolean available;

    @Column(name = "stock_sku")
    private String stockSku;


    @Column(name = "stock_bar_code")
    private String stockBarCode;

    // TODO: Produto com estoque: Limitado / Ilimitado
    @Column(name = "stock_type")
    private String stockType;

//    private Long quantity;

    public ProductModel() {
    }

    public ProductModel(
            UUID id,
            String name,
            String description,
            String videoLink,
            Double salesPrice,
            Double promotionalPrice,
            String productType,
            Boolean available,
            String stockSku,
            String stockBarCode,
            String stockType
//            Long quantity
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.videoLink = videoLink;
        this.salesPrice = salesPrice;
        this.promotionalPrice = promotionalPrice;
        this.productType = productType;
        this.available = available;
        this.stockSku = stockSku;
        this.stockBarCode = stockBarCode;
        this.stockType = stockType;
//        this.quantity = quantity;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public Double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(Double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public Double getPromotionalPrice() {
        return promotionalPrice;
    }

    public void setPromotionalPrice(Double promotionalPrice) {
        this.promotionalPrice = promotionalPrice;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
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

//    public Long getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(Long quantity) {
//        this.quantity = quantity;
//    }
}