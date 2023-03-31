package com.example.WalletProject.models.DTO;

import jakarta.validation.constraints.NotBlank;

public class CurrencyDTO {
    @NotBlank
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
