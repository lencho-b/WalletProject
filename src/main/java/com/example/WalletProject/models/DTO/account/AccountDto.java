package com.example.WalletProject.models.DTO.account;

import com.example.WalletProject.models.DTO.CurrencyNameDto;


public class AccountDto {

    private Long id;
    private String name;
    private Boolean frozen;
    private String comment;
    private Long value;
    private CurrencyNameDto currencyName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getFrozen() {
        return frozen;
    }

    public void setFrozen(Boolean frozen) {
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

    public CurrencyNameDto getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(CurrencyNameDto currencyName) {
        this.currencyName = currencyName;
    }

    public AccountDto() {
    }

    @Override
    public String toString() {
        return "AccountDto{" +
                "name='" + name + '\'' +
                ", frozen=" + frozen +
                ", comment='" + comment + '\'' +
                ", value=" + value +
                ", currencyName='" + currencyName + '\'' +
                '}';
    }
}