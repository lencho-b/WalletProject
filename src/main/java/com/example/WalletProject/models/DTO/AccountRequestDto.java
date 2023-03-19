package com.example.WalletProject.models.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public class AccountRequestDto implements Serializable
{
    @Size(max = 50)
    @NotNull
    private String name;
    @Size(max = 100)

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
}
