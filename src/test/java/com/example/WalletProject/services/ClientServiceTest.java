package com.example.WalletProject.services;

import com.example.WalletProject.models.Entity.Client;
import com.example.WalletProject.repositories.ClientRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class ClientServiceTest {
    @Mock
    private ClientRepository clientRepository;
    @InjectMocks
    private ClientService clientService;
    @Test
    void getClientByIdTest()
    {
        final Long id = 1L;
        Client client = new Client(
                "Vlad",
                "Bazin",
                "Vitalievich",
                LocalDate.parse("2023-03-17"),
                "vlad.bazin2013@gmail.com",
                "200-19-73");
//        when(clientRepository.getById(id)).thenReturn(Optional.of("Vlad"));;
//        ClientDto clientDto = clientService.getClientById(id);
//        assertEquals("Vlad",clientDto.getFirstname());
    }
}