package com.example.WalletProject.dto;

public class TransactionDTO {

    private Long value;
    private String message;

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
