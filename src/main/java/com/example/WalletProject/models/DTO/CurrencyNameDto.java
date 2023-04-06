package com.example.WalletProject.models.DTO;

import com.example.WalletProject.Messages;
import jakarta.validation.constraints.NotBlank;

public class CurrencyNameDto {
    @NotBlank(message = Messages.EMPTY_CURRENCY)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
