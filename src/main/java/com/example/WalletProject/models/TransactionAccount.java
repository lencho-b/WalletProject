package com.example.WalletProject.models;

import jakarta.persistence.*;

import javax.print.DocFlavor;
import java.util.Objects;

@Entity
public class TransactionAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    private Transaction transaction;
    @ManyToOne(fetch = FetchType.EAGER)
    private Account account;
    private boolean sender;

    public TransactionAccount() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public boolean isSender() {
        return sender;
    }

    public void setSender(boolean sender) {
        this.sender = sender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionAccount that = (TransactionAccount) o;
        if (!transaction.equals(that.transaction)) return false;
        return account.equals(that.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transaction, account);
    }
}
