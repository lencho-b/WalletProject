package com.example.WalletProject.controllers;

import com.example.WalletProject.models.DTO.AccountDto;
import com.example.WalletProject.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController
{
    @Autowired
    private AccountService accountService;

    @GetMapping("/all-accounts")
    public List<AccountDto> showAllAccounts()
    {
        List<AccountDto> accountDtos = accountService.getAllAccounts();
        return accountDtos;
    }
    @GetMapping("/{id}")
    public AccountDto showAccountById(@PathVariable("id")Long id)
    {
        AccountDto accountDto = accountService.getAccountById(id);
        return accountDto;
    }
    @PatchMapping("/{id}")
    public void updateAccountById(@PathVariable("id")Long id,AccountDto accountDto)
    {
        accountService.updateAccountById(id,accountDto);
    }
    @PostMapping()
    public void  createNewAccount(@RequestBody AccountDto accountDto)
    {
        accountService.createAccount(accountDto);
    }
    @DeleteMapping("/{id}")
    public void deleteAccountById(@PathVariable("id")Long id)
    {
        accountService.deleteAccountById(id);
    }
}
