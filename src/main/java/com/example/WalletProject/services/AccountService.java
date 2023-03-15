package com.example.WalletProject.services;

import com.example.WalletProject.models.Account;
import com.example.WalletProject.models.Role;
import com.example.WalletProject.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.List;

//Сервис для изменений и получений счетов.
@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    //пример взаимодействия сервиса и репозитория.
    public List<Account> getAccountByUserId(BigInteger clientId){
        return accountRepository.findByClientId(clientId);

    }

    public List<Account> getAccountsByAccountType(Role accountRole){

        return null;
    }
    public void saveOrUpdateAccount(Account account){

    }



}
