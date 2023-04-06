package com.example.WalletProject.models.DTO.transaction;

import com.example.WalletProject.Messages;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public class TransactionRequestDto {
    @NotBlank(message = Messages.EMPTY_ACCOUNT_ID_TO)
    private Long accountIdTo;
    @NotBlank(message = Messages.EMPTY_VALUE_OF_TRANSACTION)
    @Min(value = 0, message = Messages.INVALID_VALUE_OF_TRANSACTION)
    private BigDecimal value;
    @Max(value = 100, message = Messages.SIZE_MESSAGE)
    private String message;
    @NotBlank(message = Messages.EMPTY_TRANSACTION_TYPE)
    private String typeName;

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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
