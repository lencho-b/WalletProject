package com.example.WalletProject.controllers;

import com.example.WalletProject.dto.AccountFullInfoDTO;
import com.example.WalletProject.dto.AccountInfoForAccountsList;
import com.example.WalletProject.services.AccountWithTransactionService;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class AccountWithTransactionController {
private final AccountWithTransactionService accountWithTransactionService;

    public AccountWithTransactionController(AccountWithTransactionService accountWithTransactionService) {
        this.accountWithTransactionService = accountWithTransactionService;
    }

    public Set<AccountInfoForAccountsList> getAccountsByClientId(Long clientId){}
    public AccountFullInfoDTO getAccountByAccountId(Long accountId){}
}
