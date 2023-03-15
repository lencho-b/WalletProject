package com.example.WalletProject.controllers;

import com.example.WalletProject.models.Account;
import com.example.WalletProject.services.AccountService;
import com.example.WalletProject.services.ClientService;
import com.example.WalletProject.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

// тут все эндпоинты для клиента.
@RestController
public class ClientController {

    private ClientService clientService;
    private TransactionService transactionService;
    private AccountService accountService;

    @Autowired
    public ClientController(ClientService clientService, TransactionService transactionService, AccountService accountService) {
        this.clientService = clientService;
        this.transactionService = transactionService;
        this.accountService = accountService;
    }



}
