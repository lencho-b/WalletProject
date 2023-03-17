package com.example.WalletProject.controllers;

import com.example.WalletProject.models.DTO.AccountDto;
import com.example.WalletProject.models.DTO.ClientDto;
import com.example.WalletProject.models.DTO.TransactionDto;
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
    public ClientDto showClientById(@PathVariable("id")Long id)
    {
        ClientDto clientDto = clientService.getClientById(id);
        return clientDto;
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
    public void  createNewAccount(@PathVariable("id")Long id,@RequestBody AccountDto accountDto)
    {
        accountService.createAccountByClientId(accountDto,id);
    }
}
