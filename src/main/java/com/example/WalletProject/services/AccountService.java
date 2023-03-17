package com.example.WalletProject.services;

import com.example.WalletProject.models.DTO.AccountDto;
import com.example.WalletProject.models.Entity.Account;
import com.example.WalletProject.models.Entity.Client;
import com.example.WalletProject.models.Entity.Currency;
import com.example.WalletProject.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        List<AccountDto>accountDtos = new ArrayList<>();
        for (Account account:accounts)
        {
            accountDtos.add(new AccountDto
                    (account.getId()
                    ,account.getName()
                    ,account.getFrozen()
                    ,account.getComment()
                    ,account.getValue()
                    ,account.getCreatedAt()
                    ,account.getUpdatedAt()
                    ,account.getClient().getId()
                    ,account.getCurrency().getId()));
        }
        return accountDtos;
    }

    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id).get();
        AccountDto accountDto = new AccountDto
                        (account.getId()
                        ,account.getName()
                        ,account.getFrozen()
                        ,account.getComment()
                        ,account.getValue()
                        ,account.getCreatedAt()
                        ,account.getUpdatedAt()
                        ,account.getClient().getId()
                        ,account.getCurrency().getId());
        return accountDto;
    }

    @Transactional
    public void createAccount(AccountDto accountDto) {
        Account account = new Account();
//        account.setId(accountDto.getId());
        account.setComment(accountDto.getComment());
        account.setCreatedAt(accountDto.getCreatedAt());
        account.setFrozen(accountDto.getFrozen());
        account.setName(accountDto.getName());
        account.setUpdatedAt(accountDto.getUpdatedAt());
        account.setValue(accountDto.getValue());
        account.setClient(new Client(accountDto.getClientId()));
        account.setCurrency(new Currency(accountDto.getCurrencyId()));
        accountRepository.save(account);
    }

    public void updateAccountById(Long id, AccountDto accountDto) {
    Account account = accountRepository.getById(id);
    account.setComment(accountDto.getComment());
    account.setCreatedAt(accountDto.getCreatedAt());
    account.setFrozen(accountDto.getFrozen());
    account.setName(accountDto.getName());
    account.setUpdatedAt(accountDto.getUpdatedAt());
    account.setValue(accountDto.getValue());
        account.setClient(new Client(accountDto.getClientId()));
        account.setCurrency(new Currency(accountDto.getCurrencyId()));
    accountRepository.save(account);
    }

    public void deleteAccountById(Long id)
    {
        accountRepository.deleteById(id);
    }
}
