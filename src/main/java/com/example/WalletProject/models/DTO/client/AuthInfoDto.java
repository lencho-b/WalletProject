package com.example.WalletProject.models.DTO.client;

import com.example.WalletProject.Messages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AuthInfoDto {
    @NotBlank(message = Messages.EMPTY_PASSWORD)
    @Size(min = 7, max = 15, message = Messages.INVALID_PASSWORD)
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