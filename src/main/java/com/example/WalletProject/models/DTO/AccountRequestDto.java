package com.example.WalletProject.models.DTO;

public class AccountRequestDto
{
    private String name;
    private  String comment;
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
