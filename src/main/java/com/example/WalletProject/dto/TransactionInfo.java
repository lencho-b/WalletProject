package com.example.WalletProject.dto;

import com.example.WalletProject.models.Account;
import com.example.WalletProject.models.Transaction;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;

public class TransactionInfo {
    // инфа без Id;

    private TransactionDTO transaction;
    private Long accountId;
    private Boolean sender;

    public TransactionDTO getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionDTO transaction) {
        this.transaction = transaction;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Boolean getSender() {
        return sender;
    }

    public void setSender(Boolean sender) {
        this.sender = sender;
    }
}
