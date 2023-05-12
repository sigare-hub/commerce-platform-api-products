package com.commerceplatform.api.products.routes;

public enum ProductRoutes {
    PRODUCT("/product"),
    PRODUCT_CREATE("/product/create");

    private final String value;

    ProductRoutes(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
