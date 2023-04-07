package com.example.WalletProject.controllers;

import com.example.WalletProject.Messages;
import com.example.WalletProject.models.DTO.client.RegistrationDto;
import com.example.WalletProject.services.AuthService;
import com.example.WalletProject.services.ClientService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Validated
public class AuthController {
    private final ClientService clientService;
    private final AuthService authService;

    public AuthController(ClientService clientService, AuthService authService) {
        this.clientService = clientService;
        this.authService = authService;
    }

    @PostMapping("/registration")
    public void createNewClient(@RequestBody @Valid RegistrationDto registrationDto) {
        clientService.createNewClient(registrationDto);
    }

    @PatchMapping("/{id}")
    public void updateAuthClientById(@PathVariable("id") Long clientId,
                                     @RequestBody @Size(min=4,max = 15,message = Messages.INVALID_PASSWORD) String password) {
        authService.updateAuthClientById(password, clientId);
    }

}
