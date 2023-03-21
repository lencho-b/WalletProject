package com.example.WalletProject.dto;


import java.math.BigDecimal;

public class AccountInfoForAccountsList {
    private Long id;
    private String comment;
    private BigDecimal value;
    private String currency;
    private boolean frozen;

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

    public boolean isFrozen() {
        return frozen;
    }

    public void setFrozen(boolean frozen) {
        this.frozen = frozen;
    }
}
