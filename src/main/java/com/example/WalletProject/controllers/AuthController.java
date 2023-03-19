package com.example.WalletProject.controllers;

import com.example.WalletProject.models.DTO.RegistrationDto;
import com.example.WalletProject.services.ClientService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController
{
    private final ClientService clientService;

    public AuthController(ClientService clientService) {
        this.clientService = clientService;
    }
    @PostMapping("/registration")
    public void createNewClient(@RequestBody RegistrationDto registrationDto)
    {
        clientService.createNewClient(registrationDto);
    }
}
