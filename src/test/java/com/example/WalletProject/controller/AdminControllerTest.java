package com.example.WalletProject.controller;

import com.example.WalletProject.controllers.AdminController;
import com.example.WalletProject.models.DTO.client.ClientDto;
import com.example.WalletProject.models.DTO.client.ClientInformationForManageDto;
import com.example.WalletProject.models.DTO.country.FullCountryInfoDto;
import com.example.WalletProject.models.Entity.Client;
import com.example.WalletProject.models.Entity.Country;
import com.example.WalletProject.repositories.ClientRepository;
import com.example.WalletProject.services.ClientService;
import com.example.WalletProject.services.CountryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@WebMvcTest(controllers = AdminController.class)
public class AdminControllerTest {

    @MockBean
    private AdminController adminController;

    @MockBean
    private ClientService clientService;

    @MockBean
    private CountryService countryService;

    @MockBean
    private ModelMapper modelMapper;

    @BeforeEach
    void setUp() {
        clientService = mock(ClientService.class);
        countryService = mock(CountryService.class);
        modelMapper = mock(ModelMapper.class);

        adminController = new AdminController(
                clientService,
                countryService,
                modelMapper);
    }

    @Test
    public void testShowAllClients() {
        List<ClientDto> clientsListSize = clientService.getAllClients(0);
        List<ClientDto> clients = adminController.showAllClients(0);
        Assertions.assertEquals(clientsListSize.size(), clients.size());
    }

    @Test
    public void testShowClientById() {
        ClientService clientService = mock(ClientService.class);
        ClientRepository clientRepository = mock(ClientRepository.class);
        ModelMapper modelMapper = mock(ModelMapper.class);
        AdminController adminController = new AdminController(clientService, null, modelMapper);

        Client client = new Client();
        client.setId(1L);
        client.setFirstname("John");
        client.setLastname("Doe");
        client.setEmail("johndoe@example.com");
        Optional<Client> optionalClient = Optional.of(client);

        when(clientRepository.findById(1L)).thenReturn(optionalClient);
        when(modelMapper.map(client, ClientDto.class)).thenReturn(new ClientDto());
        when(clientService.getClientByIdForAdmin(1L)).thenReturn(new ClientDto());

        ClientDto result = adminController.showClientById(1L);

        Assertions.assertEquals(result.getClass(), ClientDto.class);
    }

    @Test
    public void testSetStatusByClientId() {
        Long id = 1L;
        ClientInformationForManageDto dto = new ClientInformationForManageDto();
        dto.setFrozen();

        adminController.setStatusByClientId(id, dto);
        verify(clientService, times(1)).updateInformationForManageByClientId(eq(id), eq(dto));
    }

    @Test
    void testDeleteClient() {
        Long id = 1L;
        adminController.deleteClient(id);
        verify(clientService).deleteClientById(id);
    }

    @Test
    void testShowCountries() {
        List<Country> countriesListSize = countryService.findAll();
        List<FullCountryInfoDto> countries = adminController.showCountries();
        Assertions.assertEquals(countriesListSize.size(), countries.size());
    }

    @Test
    public void testShowCountry() {
        Country country = new Country();
        country.setName("Россия");

        when(countryService.findByName("Россия")).thenReturn(country);
        when(modelMapper.map(country, FullCountryInfoDto.class)).thenReturn(new FullCountryInfoDto());

        FullCountryInfoDto fullCountryInfoDto = adminController.showCountry("Россия");
        assertNotNull(fullCountryInfoDto);
    }

    @Test
    void testDeleteCountry() {
        Country country = new Country();
        country.setName("Россия");
        adminController.deleteCountry(country.getName());
        verify(countryService).deleteCountry(country.getName());
    }

    @Test
    public void testUpdateCountry() {
        ClientService clientServiceMock = mock(ClientService.class);
        CountryService countryServiceMock = mock(CountryService.class);
        ModelMapper modelMapperMock = mock(ModelMapper.class);

        String name = "TestCountry";
        String phoneCode = "123";

        FullCountryInfoDto countryInfoDto = new FullCountryInfoDto();
        countryInfoDto.setName(name);
        countryInfoDto.setPhoneCode(phoneCode);

        Country countryEntity = new Country();
        countryEntity.setName(name);
        countryEntity.setPhoneCode(phoneCode);

        when(modelMapperMock.map(countryInfoDto, Country.class)).thenReturn(countryEntity);
        AdminController adminController = new AdminController(clientServiceMock, countryServiceMock, modelMapperMock);

        adminController.updateCountry(countryInfoDto);
        verify(countryServiceMock, times(1)).saveOrUpdate(countryEntity);
    }

    @Test
    public void testCreateCountry() {
        FullCountryInfoDto countryDto = new FullCountryInfoDto();
        countryDto.setName("Russia");

        Country country = new Country();
        country.setName("Russia");

        when(modelMapper.map(countryDto, Country.class)).thenReturn(country);
        adminController.createCountry(countryDto);
        verify(countryService, times(1)).saveOrUpdate(country);
    }
}