package com.example.WalletProject.models.DTO;

public class AccountDto{

    private String name;

    private Boolean frozen;

    private  String comment;

    private Long value;

    private String currencyName;

    public String getName() {
        return name;
    }

    public Boolean getFrozen() {
        return frozen;
    }

    public String getComment() {
        return comment;
    }

    public Long getValue() {
        return value;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public AccountDto(String name, Boolean frozen, String comment, Long value,String currencyName) {
        this.name = name;
        this.frozen = frozen;
        this.comment = comment;
        this.value = value;
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