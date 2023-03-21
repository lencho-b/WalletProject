package com.example.WalletProject.controllers;

import com.example.WalletProject.services.AccountWithTransactionService;
import com.example.WalletProject.services.ClientService;
import com.example.WalletProject.services.TransferService;
import org.springframework.web.bind.annotation.RestController;

// тут все эндпойнты для админа
@RestController
public class AccountWithTransactionController {
    private final AccountWithTransactionService accountWithTransactionService;

    public AccountWithTransactionController(AccountWithTransactionService accountWithTransactionService) {
        this.accountWithTransactionService = accountWithTransactionService;
    }

    public Set<AccountInfoForAccountsListDTO> getAccountsByClientId(Long clientId){}
    public AccountFullInfoDTO getAccountByAccountId(Long accountId){}
}
