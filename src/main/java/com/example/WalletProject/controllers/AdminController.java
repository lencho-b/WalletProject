package com.example.WalletProject.controllers;

import com.example.WalletProject.integrations.Rate;
import com.example.WalletProject.models.DTO.*;
import com.example.WalletProject.models.Entity.Country;
import com.example.WalletProject.services.ClientService;
import com.example.WalletProject.services.CountryService;
import com.example.WalletProject.services.CurrencyService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final ClientService clientService;
    private final CountryService countryService;
    private final CurrencyService currencyService;
    private final ModelMapper modelMapper;

    public AdminController(ClientService clientService, CountryService countryService, CurrencyService currencyService, ModelMapper modelMapper) {
        this.clientService = clientService;
        this.countryService = countryService;
        this.currencyService = currencyService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/allClients")
    public List<ClientDTO> showAllClients(@RequestParam Integer numberPage) {
        return clientService.getAllClients(numberPage);
    }
    @GetMapping("/rate")
    public List<Rate> getAllAvailableRates() throws IOException {
        return currencyService.getAllAvailableRates();
    }
    @GetMapping("/rate/{id}")
    public Rate getRate(@PathVariable("id")Integer id) throws IOException {
        return currencyService.getRate(id);
    }

    @GetMapping("/client/{id}")
    public ClientDTO showClientById(@PathVariable("id") Long id) {
        return clientService.getClientByIdForAdmin(id);
    }


    @PatchMapping("/client/{id}")
    public void setStatusByClientId(@PathVariable("id") Long id, @RequestBody ClientInformationForManageDTO clientInformationForManageDTO) {
        clientService.updateInformationForManageByClientId(id, clientInformationForManageDTO);
    }

    //soft удаление
    @DeleteMapping("/client/{id}")
    public void deleteClient(@PathVariable("id") Long id) {
        clientService.deleteClientById(id);
    }

    @PostMapping("/send-message")
    public void sendMessageToClient() {
    }

    //     если оставлять этот метод, надо учесть, где у пользователя будет показываться сообщение
//    + создать дополнительный гет-метод формы для создания админом сообщения, а для данного метода сделать дто
//можно использовать этот метод для отправки на эмейл сообщения
    @GetMapping("/{id}/accounts")
    public List<AccountInfoForAdminDTO> showAllClientAccounts(@PathVariable("id") Long clientId) {
        return null;
    }

    @GetMapping("/accounts/{id}")
    public AccountDTO showClientAccount(@PathVariable("id") Long accountId) {
        return null;
    }

    @GetMapping("/{id}/transactions")
    public List<FullTransactionInfoForAdminDTO> showTransactionsByClient(@PathVariable("id") Long clientId) {
        return null;
    }

    @GetMapping("/{id}/transactions/a")
    public List<FullTransactionInfoForAdminDTO> showTransactionsByAccount(@PathVariable("id") Long accountId) {
        return null;
    }

    @GetMapping("/countries")
    public List<CountryForAdminDTO> showCountries() {
        return countryService.findAll()
                .stream()
                .map(country -> modelMapper.map(country, CountryForAdminDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/country")
    public CountryForAdminDTO showCountry(@RequestParam String country) {
        return modelMapper.map(countryService.findByName(country), CountryForAdminDTO.class);

    }

    @PostMapping("/country/delete")
    public void deleteCountry(@RequestBody String countryName) {
        countryService.deleteCountry(countryName);
    }

    @PatchMapping("/country/update")
    public void updateCountry(@RequestBody CountryForAdminDTO country) {
        countryService.saveOrUpdate(modelMapper.map(country, Country.class));
    }

    @PostMapping("/country/create")
    public void createCountry(@RequestBody CountryForAdminDTO country) {
        countryService.saveOrUpdate(modelMapper.map(country, Country.class));
    }


}
