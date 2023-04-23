package com.commerceplatform.api.stock.models;

import jakarta.persistence.*;

@Entity
@Table(name = "product_image")
public class ProductImageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

   private String link;
   private String description;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "product_id", referencedColumnName = "id")
   private ProductModel product;

    public ProductImageModel() {
    }

    public ProductImageModel(Long id, String link, String description, ProductModel product) {
        this.id = id;
        this.link = link;
        this.description = description;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }
}
