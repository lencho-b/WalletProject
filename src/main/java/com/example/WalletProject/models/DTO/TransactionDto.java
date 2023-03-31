package com.example.WalletProject.models.DTO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class TransactionDto {
    private BigDecimal value;//big decimal - чтоб не показывать копейки.
    private String message;
    private Date startDateTime;
    private Date finishDateTime;
    private Boolean status;
    private TransactionTypeDto transactionType;
    private List<TransactionAccountShortDto> transactionAccounts;

    public TransactionDto() {
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

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Date getFinishDateTime() {
        return finishDateTime;
    }

    public void setFinishDateTime(Date finishDateTime) {
        this.finishDateTime = finishDateTime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public TransactionTypeDto getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionTypeDto transactionType) {
        this.transactionType = transactionType;
    }

    public List<TransactionAccountShortDto> getTransactionAccounts() {
        return transactionAccounts;
    }

    public void setTransactionAccounts(List<TransactionAccountShortDto> transactionAccounts) {
        this.transactionAccounts = transactionAccounts;
    }
}
