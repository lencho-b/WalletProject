package com.example.WalletProject.models.DTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

public class AccountRequestDto {
    @NotNull
    private String name;
    @NotNull
    @Max(value = 100)
    private String comment;


    public AccountRequestDto(String name, String comment) {
        this.name = name;
        this.comment = comment;
    }

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

    @Override
    public String toString() {
        return "AccountRequestDto{" +
                "name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
