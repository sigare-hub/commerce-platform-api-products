package com.commerceplatform.api.products.exceptions;

public class TokenExpirationException extends RuntimeException {
    public TokenExpirationException(String message) {
        super(message);
    }
}
