package com.example.WalletProject.exceptions;

public class ErrorResponse {
    private String errorMessage;

    public ErrorResponse(String defaultMessage) {
        this.errorMessage = defaultMessage;
    }
}
