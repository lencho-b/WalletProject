package com.example.WalletProject.models.DTO.country;

import com.example.WalletProject.Messages;
import jakarta.validation.constraints.NotBlank;

public class CountryDto {
    @NotBlank(message = Messages.EMPTY_COUNTRY_NAME)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
