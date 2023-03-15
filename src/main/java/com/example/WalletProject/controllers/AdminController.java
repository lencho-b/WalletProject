package com.example.WalletProject.controllers;

import com.example.WalletProject.services.AccountService;
import com.example.WalletProject.services.ClientService;
import com.example.WalletProject.services.GeneralSettingsService;
import com.example.WalletProject.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

// тут все эндпойнты для админа
@RestController
public class AdminController {
    private ClientService clientService;
    private TransactionService transactionService;
    private AccountService accountService;
    private GeneralSettingsService generalSettingsService;

    @Autowired
    public AdminController(ClientService clientService, TransactionService transactionService, AccountService accountService, GeneralSettingsService generalSettingsService) {
        this.clientService = clientService;
        this.transactionService = transactionService;
        this.accountService = accountService;
        this.generalSettingsService = generalSettingsService;
    }

}
