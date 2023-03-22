package com.example.WalletProject.DTO;

public class AccountRequestDTO
{
    private String name;
    private  String comment;
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

    @Override
    public String toString() {
        return "AccountRequestDto{" +
                "name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
