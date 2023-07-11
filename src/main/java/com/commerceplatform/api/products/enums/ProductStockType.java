package com.commerceplatform.api.products.enums;

public enum ProductStockType {
    FISICAL_PRODUCT("PRODUTO_FISICO"),
    DIGITAL("PRODUTO_DIGITAL");

    private final String value;

    ProductStockType(String value) {
        this.value = value;
    }
    public String getValue() {
        return this.value;
    }
}
