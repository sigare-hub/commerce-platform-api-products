package com.commerceplatform.api.products.models;

import com.commerceplatform.api.products.models.product.ProductModel;
import jakarta.persistence.*;

@Entity
@Table(name = "inventory")
public class InventoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private ProductModel productModel;

    private Long quantity;

    @Column(name = "stock_sku")
    private String stockSku;

    @Column(name = "stock_bar_code")
    private String stockBarCode;

    @Column(name = "stock_type")
    private String stockType;

    @Column(nullable = true)
    private Boolean available;

    public InventoryModel() {
    }

    public InventoryModel(Long id, ProductModel productModel, Long quantity, String stockSku, String stockBarCode, String stockType, Boolean available) {
        this.id = id;
        this.productModel = productModel;
        this.quantity = quantity;
        this.stockSku = stockSku;
        this.stockBarCode = stockBarCode;
        this.stockType = stockType;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductModel getProductModel() {
        return productModel;
    }

    public void setProductModel(ProductModel productModel) {
        this.productModel = productModel;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
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

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
