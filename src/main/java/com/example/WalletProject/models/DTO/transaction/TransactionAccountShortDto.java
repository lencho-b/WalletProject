package com.example.WalletProject.models.DTO.transaction;

public class TransactionAccountShortDto {

    private Long id;
    private Boolean sender;

    public TransactionAccountShortDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getSender() {
        return sender;
    }

    public void setSender(Boolean sender) {
        this.sender = sender;
    }
}
