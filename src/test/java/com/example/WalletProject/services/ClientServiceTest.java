package com.example.WalletProject.services;

import com.example.WalletProject.models.DTO.AuthInfoDto;
import com.example.WalletProject.models.DTO.ClientInformationForMainPageDTO;
import com.example.WalletProject.models.Entity.AuthInfo;
import com.example.WalletProject.models.Entity.Client;
import com.example.WalletProject.repositories.AuthInfoRepository;
import com.example.WalletProject.repositories.ClientRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class ClientServiceTest {
    @Mock
    private ClientRepository clientRepository;
    @Mock
    private AuthInfoRepository authInfoRepository;
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
        when(clientRepository.findById(id)).thenReturn(Optional.of(client));


        ClientInformationForMainPageDTO clientInformationForMainPageDTO = clientService.getClientById(id);


        assertEquals(client.getFirstname(),clientInformationForMainPageDTO.getFirstname());
        assertEquals(client.getLastname(),clientInformationForMainPageDTO.getLastname());
        assertEquals(client.getPatronymic(),clientInformationForMainPageDTO.getPatronymic());
        assertEquals(client.getDateOfBirth(),clientInformationForMainPageDTO.getDateOfBirth());
        assertEquals(client.getEmail(),clientInformationForMainPageDTO.getEmail());
        assertEquals(client.getPhoneNumber(),clientInformationForMainPageDTO.getPhoneNumber());

    }

    @Test
    public void updateAuthClientById()
    {
        List<AuthInfo>authInfoList = new ArrayList<>();
        String loginForDto = "Vlad222";
        String passwordForDto = "2222";
        String login = "Vlad123";
        String password = "1111";
        final Long id = 1L;
        AuthInfoDto authInfoDto = new AuthInfoDto(loginForDto,passwordForDto);
        AuthInfo authInfo = new AuthInfo(id,login,password);
        when(authInfoRepository.getById(id)).thenReturn(authInfo);
        when(authInfoRepository.save(authInfo)).thenReturn(authInfo);


        clientService.updateAuthClientById(authInfoDto,id);


        assertEquals(loginForDto,authInfo.getLogin());
        assertEquals(passwordForDto,authInfo.getPassword());
    }
}