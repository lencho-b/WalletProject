package com.example.WalletProject.models.DTO;

public class FullTransactionInfoForAdminDto {
    private Long accountId;
    private TransactionForAdminDto transactionDto;
    private boolean sender;


    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public TransactionForAdminDto getTransactionDto() {
        return transactionDto;
    }

    public void setTransactionDto(TransactionForAdminDto transactionDto) {
        this.transactionDto = transactionDto;
    }

    public boolean isSender() {
        return sender;
    }

    public void setSender(boolean sender) {
        this.sender = sender;
    }
}
