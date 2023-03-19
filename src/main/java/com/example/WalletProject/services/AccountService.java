package com.example.WalletProject.services;

import com.example.WalletProject.models.DTO.AccountDto;
import com.example.WalletProject.models.DTO.AccountRequestDto;
import com.example.WalletProject.models.DTO.TransactionDto;
import com.example.WalletProject.models.Entity.Account;
import com.example.WalletProject.models.Entity.Transaction;
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

    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        List<AccountDto>accountDtos = new ArrayList<>();
        for (Account account:accounts)
        {
            accountDtos.add(new AccountDto
                    (
                     account.getName()
                    ,account.getFrozen()
                    ,account.getComment()
                    ,account.getValue()
                    ,account.getCurrency().getId()));
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
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id).get();
        AccountDto accountDto = new AccountDto
                        (
                         account.getName()
                        ,account.getFrozen()
                        ,account.getComment()
                        ,account.getValue()
                        ,account.getCurrency().getId());
        return accountDto;
    }
    public AccountDto getClientsAccountById(Long idAcc,Long idCl)
    {
        List<Account>clientsAccounts = getClientsAccounts(idCl);
        for (Account account:clientsAccounts)
        {
            if(account.getId()==(long)idAcc)
            {
                AccountDto accountDto = new AccountDto
                        (
                                 account.getName()
                                ,account.getFrozen()
                                ,account.getComment()
                                ,account.getValue()
                                ,account.getCurrency().getId());
                return accountDto;
            }
        }
        return null;
    }

    public void createAccountByClientId(AccountDto accountDto,Long id) {
        Account account = new Account();
        account.setComment(accountDto.getComment());
        account.setName(accountDto.getName());
        account.setValue(0L);
        account.setCreatedAt(LocalDate.now());
        account.setFrozen(false);
        account.setUpdatedAt(null);
        account.setClient(clientRepository.getById(id));
        account.setCurrency(currencyRepository.getById(accountDto.getCurrencyId()));
        accountRepository.save(account);
    }
    public void deleteAccountById(Long id)
    {
        accountRepository.deleteById(id);
    }
    public List<TransactionDto> getTransactionsById(Long id)
    {
        Account account = accountRepository.getById(id);
        List<Transaction>transactions = account.getTransactions();
        List<TransactionDto>transactionDtos = new ArrayList<>();
        for (Transaction transaction:transactions)
        {
         transactionDtos.add(new TransactionDto
                 (transaction.getId()
                 ,transaction.getValue()
                 ,transaction.getMessage()
                 ,transaction.getStartDateTime()
                 ,transaction.getFinishDateTime()
                 ,transaction.getStatus()
                 ,transaction.getType().getId()));
        }
        return transactionDtos;
    }

    public void updateClientsAccountById(Long idAcc, Long idCl, AccountRequestDto accountRequestDto)
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
