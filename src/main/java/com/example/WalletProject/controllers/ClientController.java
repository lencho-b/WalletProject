package com.example.WalletProject.controllers;

import com.example.WalletProject.models.DTO.*;
import com.example.WalletProject.services.AccountService;
import com.example.WalletProject.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController
{
    @Autowired
    private ClientService clientService;
    @Autowired
    private AccountService accountService;

    @GetMapping("/main/{id}/information")
    public ClientInformationForMainPageDTO  showClientById(@PathVariable("id")Long id)
    {
        ClientInformationForMainPageDTO  clientInformationForMainPageDTO = clientService.getClientById(id);
        return clientInformationForMainPageDTO ;
    }
    @GetMapping("/main/{id}/transactions")
    public List<TransactionDto> showAllTransactionsById(@PathVariable("id")Long id)
    {
        return clientService.getAllTransactionByClientId(id);
    }
    @GetMapping("/main/{id}/accounts")
    public List<AccountDto> showAllAccountsByClienId(@PathVariable("id")Long id)
    {
        return clientService.getAllAccountsByClientId(id);
    }
    @PostMapping("/main/{id}/create")
    public void  createNewAccountByClientId(@PathVariable("id")Long id,@RequestBody AccountDto accountDto)
    {
        accountService.createAccountByClientId(accountDto,id);
    }
    @GetMapping("/main/{id}/auth")
    public AuthInfoDto showAuthInfoByClientId(@PathVariable("id")Long id)
    {
        return clientService.getAuthInfoByClientId(id);
    }
    @PatchMapping("/main/{id}/auth/update")
    public void updateAuthClientById(@PathVariable("id")Long id,@RequestBody AuthInfoDto authInfoDto)
    {
        clientService.updateAuthClientById(authInfoDto,id);
    }
    @GetMapping("/main/{id}/document")
    public DocumentDto showDocumentByClientId(@PathVariable("id")Long id)
    {
        return clientService.getDocumentByClientId(id);
    }
    @GetMapping("/main/{id}/manage-information")
    public ClientInformationForManageDTO showClientInformationForManageByClientId(@PathVariable("id")Long id)
    {
        return clientService.getClientInformationForManageByClientId(id);
    }
//    @PatchMapping("/main/{id}/document/update")
//    public void UpdateClientsDocumentById(@PathVariable("id")Long id,@RequestBody DocumentDto documentDto)
//    {
//        clientService.updateDocumentByClientId(id,documentDto);
//    }
}
