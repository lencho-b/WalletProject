package com.example.WalletProject.services;

import com.example.WalletProject.models.Account;
import com.example.WalletProject.models.AccountType;
import com.example.WalletProject.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

//Сервис для изменений и получений счетов.
@Service
public class AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    //пример взаимодействия сервиса и репозитория.
    public List<Account> getAccountsByUserId(BigInteger clientId){
        return accountRepository.findByClientId(clientId);

    }

//    public List<Account> getAccountsByAccountType(AccountType type)

    public Account getAccountById(BigInteger accountId){
        return accountRepository.findById(accountId).orElse(null);
    }

    public void saveOrUpdateAccount(Account account){

    }



}
