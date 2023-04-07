package com.example.WalletProject.models.DTO.account;

import com.example.WalletProject.Messages;
import com.example.WalletProject.models.DTO.CurrencyNameDto;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class AccountRequestDto {
    @NotEmpty(message = Messages.EMPTY_ACCOUNTS_NAME)
    @Pattern(regexp = "^[а-яА-Я]+$", flags = Pattern.Flag.CASE_INSENSITIVE)
    private String name;
    @Size(max= 100, message = Messages.SIZE_COMMENT)
    private String comment;
    @NotNull(message = Messages.EMPTY_CURRENCY)
    private CurrencyNameDto currency;

    public AccountRequestDto() {
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

    public CurrencyNameDto getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyNameDto currency) {
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
