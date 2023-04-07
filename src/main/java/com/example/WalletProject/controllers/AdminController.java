package com.example.WalletProject.controllers;

import com.example.WalletProject.models.DTO.client.ClientDto;
import com.example.WalletProject.models.DTO.client.ClientInformationForManageDto;
import com.example.WalletProject.models.DTO.country.FullCountryInfoDto;
import com.example.WalletProject.models.Entity.Country;
import com.example.WalletProject.services.ClientService;
import com.example.WalletProject.services.CountryService;
import com.example.WalletProject.services.CurrencyService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/admin")
@Validated
public class AdminController {
    private final ClientService clientService;
    private final CountryService countryService;
    private final ModelMapper modelMapper;

    public AdminController(ClientService clientService, CountryService countryService, ModelMapper modelMapper) {
        this.clientService = clientService;
        this.countryService = countryService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/allClients")
    public Page<ClientDto> showAllClients(@PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return clientService.getAllClients(pageable);
    }

    @GetMapping("/client/{id}")
    public ClientDto showClientById(@PathVariable("id") Long id) {
        return clientService.getClientByIdForAdmin(id);
    }


    @PatchMapping("/client/{id}")
    public void setStatusByClientId(@PathVariable("id") Long id, @RequestBody ClientInformationForManageDto clientInformationForManageDTO) {
        clientService.updateInformationForManageByClientId(id, clientInformationForManageDTO);
    }

    @DeleteMapping("/client/{id}")
    public void deleteClient(@PathVariable("id") Long id) {
        clientService.deleteClientById(id);
    }


    @GetMapping("/countries")
    public Page<FullCountryInfoDto> showCountries(@PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return countryService.findAll(pageable);

    }

    @GetMapping("/country")
    public FullCountryInfoDto showCountry(@RequestParam String country) {
        return countryService.findByName(country);
    }

    @DeleteMapping("/country")
    public void deleteCountry(@RequestParam String country) {
        countryService.deleteCountry(country);
    }

    @PatchMapping("/country")
    public void updateCountry(@RequestBody @Valid FullCountryInfoDto country) {
        countryService.saveOrUpdate(country);
    }

    @PostMapping("/country")
    public void createCountry(@RequestBody @Valid FullCountryInfoDto country) {
        countryService.saveOrUpdate(country);
    }
}