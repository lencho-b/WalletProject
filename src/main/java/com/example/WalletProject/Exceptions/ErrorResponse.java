package com.example.WalletProject.Exceptions;

public class ErrorResponse {
    private String errorMessage;

    public ErrorResponse(String defaultMessage) {
        this.errorMessage = defaultMessage;
    }
}
