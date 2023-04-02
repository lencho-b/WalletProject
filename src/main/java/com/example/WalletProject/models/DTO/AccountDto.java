package com.example.WalletProject.models.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

// дто должен быть валидирован
public class AccountDto {
    @NotNull
    private Long id;
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


    public AccountDto(Long id, String name, Boolean frozen, String comment, Long value, String currencyName) {
        this.id = id;
        this.name = name;
        this.frozen = frozen;
        this.comment = comment;
        this.value = value;
        this.currencyName = currencyName;
    }

    public AccountDto() {
    }

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

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
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