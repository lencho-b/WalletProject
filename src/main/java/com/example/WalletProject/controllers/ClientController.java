package com.example.WalletProject.controllers;

import com.example.WalletProject.models.DTO.*;
import com.example.WalletProject.services.AccountService;
import com.example.WalletProject.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private AccountService accountService;

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

    @GetMapping("/{id}/transactions")
    public List<TransactionDto> showAllTransactionsById(@PathVariable("id") Long id) {
        return clientService.getAllTransactionByClientId(id);
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
        return clientService.getAuthInfoByClientId(id);
    }

    @PatchMapping("/{id}/auth/update")
    public void updateAuthClientById(@PathVariable("id") Long id, @RequestBody AuthInfoDto authInfoDto) {
        clientService.updateAuthClientById(authInfoDto, id);
    }

    @GetMapping("/{id}/document")
    public DocumentResponseDto showDocumentByClientId(@PathVariable("id") Long id) {
        return clientService.getDocumentByClientId(id);
    }

    @GetMapping("/{id}/manage-information")
    public ClientInformationForManageDTO showClientInformationForManageByClientId(@PathVariable("id") Long id) {
        return clientService.getClientInformationForManageByClientId(id);
    }

    @PostMapping("/{id}/document/create")
    public void updateClientsDocumentById(@PathVariable("id") Long id, @RequestBody DocumentRequestDto documentRequestDto) {
        clientService.createDocumentByClientId(id, documentRequestDto);
    }

    @DeleteMapping("/{id}/document/delete")
    public void deleteClientsDocumentById(@PathVariable("id") Long id) {
        clientService.deleteClientsDocumentByClientId(id);
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
