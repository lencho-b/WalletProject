package com.example.WalletProject.dto;

import com.example.WalletProject.models.TransactionAccount;

import java.util.List;

public class AccountFullInfoDTO {

    private boolean frozen;
    private String comment;
    private Long value;
    private String currency;
    private List<TransactionInfo> transactions;

    public boolean isFrozen() {
        return frozen;
    }

    public void setFrozen(boolean frozen) {
        this.frozen = frozen;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<TransactionInfo> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionInfo> transactions) {
        this.transactions = transactions;
    }
}
