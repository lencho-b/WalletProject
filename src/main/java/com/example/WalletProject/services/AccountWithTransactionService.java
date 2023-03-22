package com.example.WalletProject.services;

import com.example.WalletProject.models.Account;
import com.example.WalletProject.repositories.AccountRepository;
import com.example.WalletProject.repositories.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

//Сервис для изменений и получений счетов.
@Service
public class AccountWithTransactionService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public AccountWithTransactionService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    public Set<Account> allAccountByClientId(Long clientId){
        return accountRepository.findByClientId(clientId);
    }

    public Account accountByAccountId(Long accountId){
        return accountRepository.findById(accountId).orElse(null);
    }
}
