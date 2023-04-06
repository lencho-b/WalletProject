package com.example.WalletProject.controllers;

import com.example.WalletProject.models.DTO.*;
import com.example.WalletProject.models.DTO.account.AccountDto;
import com.example.WalletProject.models.DTO.account.AccountRequestDto;
import com.example.WalletProject.models.DTO.client.ClientInformationForMainPageDto;
import com.example.WalletProject.models.DTO.client.ClientInformationForManageDto;
import com.example.WalletProject.services.AccountService;
import com.example.WalletProject.services.ClientService;
import com.example.WalletProject.services.DocumentService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;
    private final AccountService accountService;
    private final DocumentService documentService;

    public ClientController(ClientService clientService, AccountService accountService, DocumentService documentService) {
        this.clientService = clientService;
        this.accountService = accountService;
        this.documentService = documentService;
    }

    @GetMapping("/{id}/information")
    public ClientInformationForMainPageDto showClientById(@PathVariable("id") Long id) {
        return clientService.getClientById(id);
    }

    @PatchMapping("/{id}/information/")
    public void updateInformationByClientId(@PathVariable("id") Long id, @Validated
    @RequestBody ClientInformationForMainPageDto clientInformationForMainPageDTO) {
        clientService.updateInformationByClientId(id, clientInformationForMainPageDTO);
    }
    @GetMapping("/{id}/manage-information")
    public ClientInformationForManageDto showClientInformationForManageByClientId(@PathVariable("id") Long id) {
        return clientService.getClientInformationForManageByClientId(id);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteClient(@PathVariable("id") Long clientId){
        clientService.deleteClientById(clientId);
    }

    @GetMapping("/{id}/account")
    public List<AccountDto> showAllAccountsByClientId(@PathVariable("id") Long id) {
        return accountService.getAllAccountsByClientId(id);
    }

    @GetMapping("/{id}/account/{idAcc}")
    public AccountDto showClientsAccountById(@PathVariable("idAcc") Long idAcc, @PathVariable("id") Long idCl) {
        return accountService.getClientsAccountById(idAcc, idCl);
    }

// вроде договорились, что для создания принимается AccountRequestDto, так что изменила на него.
    @PostMapping("/{id}/account/create")
    public void createNewAccountByClientId(@PathVariable("id") Long id, @RequestBody AccountRequestDto accountRequestDto) {
        accountService.createAccountByClientId(accountRequestDto, id);
    }

    @PatchMapping("/{id}/account/{idAcc}")
    public void updateClientsAccountById
            (@PathVariable("idAcc") Long idAcc, @PathVariable("id") Long idCl, @RequestBody AccountRequestDto accountRequestDto) {
        accountService.updateClientsAccountById(idAcc, idCl, accountRequestDto);
    }

//    @GetMapping("/{id}/document")
//    public DocumentDto showDocumentByClientId(@PathVariable("id") Long id) {
//        return documentService.getDocumentByClientId(id);
//    }
//
//    @PostMapping("/{id}/document")
//    public void updateClientsDocumentById(@PathVariable("id") Long id,@RequestBody DocumentDto documentDto) {
//        documentService.createDocumentByClientId(id, documentDto);
//    }

    @DeleteMapping("/{id}/document")
    public void deleteClientsDocumentById(@PathVariable("id") Long id) {
        documentService.deleteClientsDocumentByClientId(id);
    }

}
