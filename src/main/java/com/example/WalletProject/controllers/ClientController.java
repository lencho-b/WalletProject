package com.example.WalletProject.controllers;

import com.example.WalletProject.dto.ClientDTO;
import com.example.WalletProject.mapper.ClientDtoMapper;
import com.example.WalletProject.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

// тут все эндпоинты для клиента.
@RestController
public class ClientController {

    private final ClientService clientService;
    private final ClientDtoMapper clientDtoMapper;

    @Autowired
    public ClientController(ClientService clientService, ClientDtoMapper clientDtoMapper) {
        this.clientService = clientService;
        this.clientDtoMapper = clientDtoMapper;
    }

    public ClientDTO getClientById(Long clientId){
        return clientDtoMapper.toDto(clientService.clientById(clientId));
    }


}
