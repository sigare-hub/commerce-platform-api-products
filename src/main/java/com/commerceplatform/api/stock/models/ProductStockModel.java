package com.commerceplatform.api.stock.models;

import jakarta.persistence.*;

@Entity
@Table(name = "product_stock")
public class ProductStockModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private ProductModel productModel;

    private Long quantity;

    public ProductStockModel() {
    }

    public ProductStockModel(Long id, ProductModel productModel, Long quantity) {
        this.id = id;
        this.productModel = productModel;
        this.quantity = quantity;
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
}
