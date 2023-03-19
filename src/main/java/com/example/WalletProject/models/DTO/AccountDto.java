package com.example.WalletProject.models.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.WalletProject.models.Entity.Account} entity
 */
public class AccountDto implements Serializable {
    @Size(max = 50)
    @NotNull
    private String name;
    @NotNull
    private Boolean frozen;
    @Size(max = 100)
    @NotNull
    private  String comment;
    @NotNull
    private Long value;
    @NotNull
    private Integer currencyId;

    public String getName() {
        return name;
    }

    public Boolean getFrozen() {
        return frozen;
    }

    public String getComment() {
        return comment;
    }

    public Long getValue() {
        return value;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public AccountDto(String name, Boolean frozen, String comment, Long value,Integer currencyId) {
        this.name = name;
        this.frozen = frozen;
        this.comment = comment;
        this.value = value;
        this.currencyId = currencyId;
    }

    public AccountDto() {
    }
}