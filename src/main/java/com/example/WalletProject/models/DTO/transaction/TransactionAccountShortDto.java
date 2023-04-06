package com.example.WalletProject.models.DTO.transaction;

import com.example.WalletProject.models.DTO.account.AccountIdDto;

public class TransactionAccountShortDto {

    private Long id;
    private AccountIdDto account;
    private Boolean sender;

    public TransactionAccountShortDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountIdDto getAccount() {
        return account;
    }

    public void setAccount(AccountIdDto account) {
        this.account = account;
    }

    public Boolean getSender() {
        return sender;
    }

    public void setSender(Boolean sender) {
        this.sender = sender;
    }
}
