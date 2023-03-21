package com.example.WalletProject.controllers;

import com.example.WalletProject.models.DTO.*;
import com.example.WalletProject.services.AccountService;
import com.example.WalletProject.services.AuthService;
import com.example.WalletProject.services.ClientService;
import com.example.WalletProject.services.DocumentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;
    private final AccountService accountService;
    private final DocumentService documentService;
    private final AuthService authService;

    public ClientController(ClientService clientService, AccountService accountService, DocumentService documentService, AuthService authService) {
        this.clientService = clientService;
        this.accountService = accountService;
        this.documentService = documentService;
        this.authService = authService;
    }

    @GetMapping("/{id}/information")
    public ClientInformationForMainPageDTO showClientById(@PathVariable("id") Long id) {
        ClientInformationForMainPageDTO clientInformationForMainPageDTO = clientService.getClientById(id);
        return clientInformationForMainPageDTO;
    }
    @PatchMapping("/{id}/information/update")
    public void updateInformationByClientId(@PathVariable("id")Long id,
    @RequestBody ClientInformationForMainPageDTO clientInformationForMainPageDTO)
    {
        clientService.updateInformationByClientId(id,clientInformationForMainPageDTO);
    }
    @GetMapping("/{id}/account")
    public List<AccountDto> showAllAccountsByClienId(@PathVariable("id") Long id) {
        return accountService.getAllAccountsByClientId(id);
    }

    @PostMapping("/{id}/account/create")
    public void createNewAccountByClientId(@PathVariable("id") Long id, @RequestBody AccountDto accountDto) {
        accountService.createAccountByClientId(accountDto,id);
    }

    @GetMapping("/{id}/auth")
    public AuthInfoDto showAuthInfoByClientId(@PathVariable("id") Long id) {
        return authService.getAuthInfoByClientId(id);
    }

    @PatchMapping("/{id}/auth/update")
    public void updateAuthClientById(@PathVariable("id") Long id, @RequestBody AuthInfoDto authInfoDto) {
        authService.updateAuthClientById(authInfoDto, id);
    }

    @GetMapping("/{id}/document")
    public DocumentDto showDocumentByClientId(@PathVariable("id") Long id) {
        return documentService.getDocumentByClientId(id);
    }

    @GetMapping("/{id}/manage-information")
    public ClientInformationForManageDTO showClientInformationForManageByClientId(@PathVariable("id") Long id) {
        return clientService.getClientInformationForManageByClientId(id);
    }

    @PostMapping("/{id}/document/create")
    public void updateClientsDocumentById(@PathVariable("id") Long id, @RequestBody DocumentDto documentDto) {
        documentService.createDocumentByClientId(id, documentDto);
    }

    @DeleteMapping("/{id}/document/delete")
    public void deleteClientsDocumentById(@PathVariable("id") Long id) {
        documentService.deleteClientsDocumentByClientId(id);
    }

    @GetMapping("/{id}/account/{idAcc}")
    public AccountDto showClientsAccountById(@PathVariable("idAcc") Long idAcc, @PathVariable("id") Long idCl) {
        return accountService.getClientsAccountById(idAcc, idCl);
    }

    @PatchMapping("/{id}/account/{idAcc}/update")
    public void updateClientsAccountById
            (@PathVariable("idAcc") Long idAcc, @PathVariable("id") Long idCl, @RequestBody AccountRequestDto accountRequestDto) {
        accountService.updateClientsAccountById(idAcc, idCl, accountRequestDto);
    }
}
