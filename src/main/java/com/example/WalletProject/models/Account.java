package com.example.WalletProject.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean frozen;

    private String comment;

    private Long value;

    private Date created_at;

    private Date updated_at;

    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    private Currency currency;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    private List<TransactionAccount> transactionAccounts;

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public List<TransactionAccount> getTransactionAccounts() {
        return transactionAccounts;
    }

    public void setTransactionAccounts(List<TransactionAccount> transactionAccounts) {
        this.transactionAccounts = transactionAccounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        if (id != account.id) return false;
        if (!client.equals(account.client)) return false;
        if (value!=account.value) return false;
        if (created_at != null ? !created_at.equals(account.created_at) : account.created_at != null) return false;
        return  (currency.equals(account.currency));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, created_at, client, currency);
    }
}
