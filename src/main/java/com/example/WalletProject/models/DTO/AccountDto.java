package com.example.WalletProject.models.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

// дто должен быть валидирован
public class AccountDto {

    @NotNull
    @Pattern(regexp = "[a-zа-я]", flags = Pattern.Flag.CASE_INSENSITIVE)
    private String name;
    @NotNull
    private Boolean frozen;
    @NotNull
    private String comment;
    private Long value;
    @NotNull
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

    public AccountDto(String name, Boolean frozen, String comment, Long value, String currencyName) {
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