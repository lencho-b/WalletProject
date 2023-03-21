package com.example.WalletProject.services;

import com.example.WalletProject.models.Client;
import com.example.WalletProject.repositories.ClientRepository;
import org.springframework.stereotype.Service;

// Сервис для получений и изменений клиенской информации и инфо по аутентификации.
@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client clientById(Long clientId){
        return clientRepository.getReferenceById(clientId);
    }
}
