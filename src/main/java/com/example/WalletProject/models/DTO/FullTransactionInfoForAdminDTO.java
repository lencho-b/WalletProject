package com.example.WalletProject.models.DTO;

public class FullTransactionInfoForAdminDTO {
    private Long accountId;
    private TransactionForAdminDTO transactionDto;
    private boolean sender;


    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public TransactionForAdminDTO getTransactionDto() {
        return transactionDto;
    }

    public void setTransactionDto(TransactionForAdminDTO transactionDto) {
        this.transactionDto = transactionDto;
    }

    public boolean isSender() {
        return sender;
    }

    public void setSender(boolean sender) {
        this.sender = sender;
    }
}
