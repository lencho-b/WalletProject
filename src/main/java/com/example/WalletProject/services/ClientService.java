package com.example.WalletProject.services;

import com.example.WalletProject.models.DTO.AccountDto;
import com.example.WalletProject.models.DTO.ClientDto;
import com.example.WalletProject.models.DTO.TransactionDto;
import com.example.WalletProject.models.Entity.Account;
import com.example.WalletProject.models.Entity.Client;
import com.example.WalletProject.repositories.AccountRepository;
import com.example.WalletProject.repositories.ClientRepository;
import com.example.WalletProject.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService
{
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    AccountService accountService;
    public ClientDto getClientById(Long id)
    {
        Client client = clientRepository.findById(id).get();
        ClientDto clientDto = new ClientDto
                (client.getFirstname()
                ,client.getLastname()
                ,client.getPatronymic()
                ,client.getDateOfBirth()
                ,client.getEmail()
                ,client.getPhoneNumber());
        return clientDto;
    }
    public List<TransactionDto> getAllTransactionByClientId(Long id)
    {

        accountRepository.findAll();
        List<TransactionDto>transactionsByClientid = new ArrayList<>();
        List<Account>accounts = accountRepository.findAll();
        for (Account account:accounts)
        {
            if(account.getClient().getId()==id.longValue())
            {
                transactionsByClientid.addAll(accountService.getTransactionsById(account.getId()));
            }
        }
        return transactionsByClientid;
    }
    public List<AccountDto> getAllAccountsByClientId(Long id)
    {
        List<AccountDto>accountsByClientid = new ArrayList<>();
        List<Account>accounts = accountRepository.findAll();
        for (Account account:accounts)
        {
            if(account.getClient().getId() == (long)id) {
                accountsByClientid.add(new AccountDto
                        (account.getId()
                                , account.getName()
                                , account.getFrozen()
                                , account.getComment()
                                , account.getValue()
                                , account.getCreatedAt()
                                , account.getUpdatedAt()
                                , account.getClient().getId()
                                , account.getCurrency().getId()));
            }
        }
        return accountsByClientid;
    }
}
