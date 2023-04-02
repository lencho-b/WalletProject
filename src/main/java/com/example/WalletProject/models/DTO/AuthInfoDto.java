package com.example.WalletProject.models.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AuthInfoDto {
    @NotNull
    @Size(min = 7, max = 15, message = "incorrect password")
    private String password;

    public AuthInfoDto(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "password = " + password + ")";
    }
}