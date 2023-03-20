package com.example.WalletProject.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long value;
    private String message;
    private Date startDateTime;
    private Date finishDateTime;
    private Boolean status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    private TransactionType transactionType;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "transaction")
    private List<TransactionAccount> transactionAccounts;

    public Transaction() {
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Date getFinishDateTime() {
        return finishDateTime;
    }

    public void setFinishDateTime(Date finishDateTime) {
        this.finishDateTime = finishDateTime;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
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
        Transaction that = (Transaction) o;

        if (id != that.id) return false;
        if (value != that.value) return false;
        return startDateTime.equals(that.startDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, startDateTime);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", value=" + value +
                ", message='" + message + '\'' +
                ", startDateTime=" + startDateTime +
                ", finishDateTime=" + finishDateTime +
                ", status=" + status +
                '}';
    }
}
