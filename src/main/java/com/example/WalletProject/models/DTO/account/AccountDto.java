package com.example.WalletProject.models.DTO.account;

// дто должен быть валидирован
public class AccountDto {

    private Long id;
    private String name;
    private Boolean frozen;
    private String comment;
    private Long value;
    private String currencyName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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