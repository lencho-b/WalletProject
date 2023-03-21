package com.example.WalletProject.controllers;

import com.example.WalletProject.dto.ClientDTO;
import com.example.WalletProject.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

// тут все эндпоинты для клиента.
@RestController
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;

    }

    public ClientDTO getClientById(Long clientId){}


}
