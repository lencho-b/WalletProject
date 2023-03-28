package com.example.WalletProject.models.DTO;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FullTransactionInfoDto {
    private Long accountIdTo;
    private BigDecimal value;//big decimal - чтоб не показывать копейки.
    private String message;
    private String typeName;

    public FullTransactionInfoDto() {
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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
