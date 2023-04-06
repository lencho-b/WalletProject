package com.example.WalletProject.models.DTO.transaction;

import java.util.List;

public class TransactionShortDto {
    private Long id;
    private Long value;
    private Boolean status;
    private List<TransactionAccountShortDto> transactionAccounts;

    public TransactionShortDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<TransactionAccountShortDto> getTransactionAccounts() {
        return transactionAccounts;
    }

    public void setTransactionAccounts(List<TransactionAccountShortDto> transactionAccounts) {
        this.transactionAccounts = transactionAccounts;
    }
}
