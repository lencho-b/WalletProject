package com.example.WalletProject.models.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link com.example.WalletProject.models.Entity.Account} entity
 */
public class AccountDto implements Serializable {
    private  Long id;
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
    private  LocalDate createdAt;
    @NotNull
    private  LocalDate updatedAt;
    @NotNull
    private Long clientId;
    @NotNull
    private Integer currencyId;

    public Long getId() {
        return id;
    }

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

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public Long getClientId() {
        return clientId;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public AccountDto(Long id, String name, Boolean frozen, String comment, Long value, LocalDate createdAt, LocalDate updatedAt, Long clientId, Integer currencyId) {
        this.id = id;
        this.name = name;
        this.frozen = frozen;
        this.comment = comment;
        this.value = value;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.clientId = clientId;
        this.currencyId = currencyId;
    }

    public AccountDto() {
    }
}