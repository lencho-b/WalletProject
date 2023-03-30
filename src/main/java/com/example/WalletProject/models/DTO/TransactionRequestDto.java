package com.example.WalletProject.models.DTO;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.math.BigDecimal;

public class TransactionRequestDto {
    @NotBlank
    private Long accountIdTo;
    @NotEmpty
    @Min(value = 0)
    private BigDecimal value;//big decimal - чтоб не показывать копейки.
    private String message;
    @NotEmpty
    private TransactionTypeDto type;

    public TransactionRequestDto() {
    }

    public Long getAccountIdTo() {
        return accountIdTo;
    }

    public void setAccountIdTo(Long accountIdTo) {
        this.accountIdTo = accountIdTo;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TransactionTypeDto getType() {
        return type;
    }

    public void setType(TransactionTypeDto type) {
        this.type = type;
    }
}
