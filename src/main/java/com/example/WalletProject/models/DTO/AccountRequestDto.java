package com.example.WalletProject.models.DTO;
// валидация нужна
public class AccountRequestDto {
    private String name;
    private String comment;

    // валюту надо добавить

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

    @Override
    public String toString() {
        return "AccountRequestDto{" +
                "name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
