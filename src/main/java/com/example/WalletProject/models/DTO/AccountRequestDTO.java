package com.example.WalletProject.models.DTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class AccountRequestDTO {
    @NotNull
    private String name;
    @NotNull
    @Max(value = 100)
    private String comment;

    @NotEmpty
    private CurrencyDTO currency;

    public AccountRequestDTO(String name, String comment) {
        this.name = name;
        this.comment = comment;
    }

    public AccountRequestDTO() {
    }

    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public CurrencyDTO getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyDTO currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "AccountRequestDto{" +
                "name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
