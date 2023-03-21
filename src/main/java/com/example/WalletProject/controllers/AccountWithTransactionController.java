package com.example.WalletProject.controllers;

import com.example.WalletProject.dto.AccountFullInfoDTO;
import com.example.WalletProject.dto.AccountInfoForAccountsList;
import com.example.WalletProject.mapper.AccountFullInfoDTOMapper;
import com.example.WalletProject.mapper.AccountInfoForAccountsListMapper;
import com.example.WalletProject.services.AccountWithTransactionService;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

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

    public Set<AccountInfoForAccountsList> getAccountsByClientId(Long clientId){}
    public AccountFullInfoDTO getAccountByAccountId(Long accountId){}
}
