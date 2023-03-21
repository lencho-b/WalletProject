package com.example.WalletProject.controllers;

import com.example.WalletProject.services.AccountWithTransactionService;
import com.example.WalletProject.services.ClientService;
import org.springframework.web.bind.annotation.RestController;

// тут все эндпоинты для клиента.
@RestController
public class ClientController {

    private ClientService clientService;

    private AccountWithTransactionService accountService;

    public ClientDTO getClientById(Long clientId){}
}
