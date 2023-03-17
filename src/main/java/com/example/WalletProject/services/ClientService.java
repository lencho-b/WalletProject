package com.example.WalletProject.services;

import com.example.WalletProject.models.DTO.ClientDto;
import com.example.WalletProject.models.Entity.Client;
import com.example.WalletProject.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService
{
    @Autowired
    private ClientRepository clientRepository;
    public ClientDto getClientById(Long id)
    {
        Client client = clientRepository.findById(id).get();
        ClientDto clientDto = new ClientDto
                (client.getFirstname()
                ,client.getLastname()
                ,client.getPatronymic()
                ,client.getDateOfBirth()
                ,client.getEmail()
                ,client.getPhoneNumber());
        return clientDto;
    }
}
