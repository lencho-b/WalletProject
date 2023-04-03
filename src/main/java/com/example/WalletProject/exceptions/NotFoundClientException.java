package com.example.WalletProject.exceptions;

public class NotFoundClientException extends RuntimeException {
    public NotFoundClientException(String message) {
        super(message);
    }
}
