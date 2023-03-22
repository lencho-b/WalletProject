package com.example.WalletProject.controllers;

import com.example.WalletProject.dto.AccountFullInfoDTO;
import com.example.WalletProject.dto.AccountInfoForAccountsList;
import com.example.WalletProject.mapper.AccountFullInfoDTOMapper;
import com.example.WalletProject.mapper.AccountInfoForAccountsListMapper;
import com.example.WalletProject.services.AccountWithTransactionService;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class AccountWithTransactionController {
private final AccountWithTransactionService accountWithTransactionService;
private final AccountFullInfoDTOMapper accountFullInfoDTOMapper;
private final AccountInfoForAccountsListMapper accountInfoForAccountsListMapper;

    public AccountWithTransactionController(AccountWithTransactionService accountWithTransactionService, AccountFullInfoDTOMapper accountFullInfoDTOMapper, AccountInfoForAccountsListMapper accountInfoForAccountsListMapper) {
        this.accountWithTransactionService = accountWithTransactionService;
        this.accountFullInfoDTOMapper = accountFullInfoDTOMapper;
        this.accountInfoForAccountsListMapper = accountInfoForAccountsListMapper;
    }

    public Set<AccountInfoForAccountsList> getAccountsByClientId(Long clientId){
        return accountWithTransactionService.allAccountByClientId(clientId).stream()
                .map(e ->  accountInfoForAccountsListMapper.toDto(e)).collect(Collectors.toSet());
    }
    public AccountFullInfoDTO getAccountByAccountId(Long accountId){
        return accountFullInfoDTOMapper.toDto(accountWithTransactionService.accountByAccountId(accountId));
    }
}
