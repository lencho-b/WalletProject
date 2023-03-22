package com.example.WalletProject.services;

import com.example.WalletProject.DTO.AccountDTO;
import com.example.WalletProject.DTO.AccountRequestDTO;
import com.example.WalletProject.entity.Account;
import com.example.WalletProject.repositories.AccountRepository;
import com.example.WalletProject.repositories.ClientRepository;
import com.example.WalletProject.repositories.CurrencyRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final ClientRepository clientRepository;
    private final CurrencyRepository currencyRepository;

    public AccountService(AccountRepository accountRepository, ClientRepository clientRepository, CurrencyRepository currencyRepository) {
        this.accountRepository = accountRepository;
        this.clientRepository = clientRepository;
        this.currencyRepository = currencyRepository;
    }
//    для админа
    public List<AccountDTO> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        List<AccountDTO>accountDtos = new ArrayList<>();
        for (Account account:accounts)
        {
            accountDtos.add(new AccountDTO
                    (
                     account.getName()
                    ,account.getFrozen()
                    ,account.getComment()
                    ,account.getValue()
                    ,account.getCurrency().getName()));
        }
        return accountDtos;
    }

    public List<Account> getClientsAccounts(Long id)
    {
        List<Account>accounts = accountRepository.findAll();
        List<Account>clientsAccounts= new ArrayList<>();
        for (Account acc:accounts)
        {
            if (acc.getClient().getId()==(long)id)
            {
                clientsAccounts.add(acc);
            }
        }
        return clientsAccounts;
    }
//    для админа
    public AccountDTO getAccountById(Long id) {
        Account account = accountRepository.findById(id).get();
        AccountDTO accountDto = new AccountDTO
                        (
                         account.getName()
                        ,account.getFrozen()
                        ,account.getComment()
                        ,account.getValue()
                        ,account.getCurrency().getName());
        return accountDto;
    }
    public AccountDTO getClientsAccountById(Long idAcc, Long idCl)
    {
        List<Account>clientsAccounts = getClientsAccounts(idCl);
        for (Account account:clientsAccounts)
        {
            if(account.getId()==(long)idAcc)
            {
                AccountDTO accountDto = new AccountDTO
                        (
                                 account.getName()
                                ,account.getFrozen()
                                ,account.getComment()
                                ,account.getValue()
                                ,account.getCurrency().getName());
                return accountDto;
            }
        }
        return null;
    }
    public List<AccountDTO> getAllAccountsByClientId(Long id) {
        List<AccountDTO> accountsByClientid = new ArrayList<>();
        List<Account> accounts = accountRepository.findAll();

        for (Account account : accounts) {
            if (account.getClient().getId() == (long) id) {
                accountsByClientid.add
                        (new AccountDTO
                                (
                                        account.getName()
                                        , account.getFrozen()
                                        , account.getComment()
                                        , account.getValue()
                                        , account.getCurrency().getName()));
            }
        }
        return accountsByClientid;
    }

    public void createAccountByClientId(AccountDTO accountDto, Long id) {
        Account account = new Account();
        account.setComment(accountDto.getComment());
        account.setName(accountDto.getName());
        account.setValue(0L);
        account.setCreatedAt(LocalDate.now());
        account.setFrozen(false);
        account.setUpdatedAt(null);
        account.setClient(clientRepository.getById(id));
        account.setCurrency(currencyRepository.getCurrencyByNameLike(accountDto.getCurrencyName()).get());
        accountRepository.save(account);
    }
//    для админа
    public void deleteAccountById(Long id)
    {
        accountRepository.deleteById(id);
    }
    public void updateClientsAccountById(Long idAcc, Long idCl, AccountRequestDTO accountRequestDto)
    {
            Account account = accountRepository.getById(idAcc);
            if(account.getClient().getId() == (long)idCl) {
                account.setComment(accountRequestDto.getComment());
                account.setName(accountRequestDto.getName());
                account.setUpdatedAt(LocalDate.now());
                accountRepository.save(account);
            }
    }
}
