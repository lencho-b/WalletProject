package com.example.WalletProject.services;

import com.example.WalletProject.models.DTO.AccountDto;
import com.example.WalletProject.models.DTO.AccountRequestDto;
import com.example.WalletProject.models.Entity.Account;
import com.example.WalletProject.repositories.AccountRepository;
import com.example.WalletProject.repositories.ClientRepository;
import com.example.WalletProject.repositories.CurrencyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final ClientRepository clientRepository;
    private final CurrencyRepository currencyRepository;
    private final ModelMapper modelMapper;

    public AccountService(AccountRepository accountRepository, ClientRepository clientRepository, CurrencyRepository currencyRepository, ModelMapper modelMapper) {
        this.accountRepository = accountRepository;
        this.clientRepository = clientRepository;
        this.currencyRepository = currencyRepository;
        this.modelMapper = modelMapper;
    }

    //    для админа
    public List<AccountDto> getAllAccounts(Integer numberOfPage) {
        Page<Account> accounts = accountRepository.findAll(PageRequest.of(numberOfPage, 20));
        return accounts.stream()
                .map(account -> modelMapper.map(account, AccountDto.class))
                .collect(Collectors.toList());
    }


    public List<AccountDto> getAllAccountsByClientId(Long id) {
        return accountRepository.findAccountsByClientId(id)
                .stream()
                .map(account -> modelMapper.map(account, AccountDto.class)
                )
                .collect(Collectors.toList());
    }

    public AccountDto getAccountById(Long id) {
        Account account = findOrThrow(id);
        return modelMapper.map(account, AccountDto.class);
    }

    public AccountDto getClientsAccountById(Long idAcc, Long idCl) {
        Account account = accountRepository.findAccountByIdAndByClientId(idAcc, idCl)
                .orElseThrow(() -> new EntityNotFoundException("Account not found"));
        return modelMapper.map(account, AccountDto.class);
    }

    public void createAccountByClientId(AccountDto accountDto, Long id) {
        Account account = modelMapper.map(accountDto, Account.class);
        account.setClient(clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client not found")));
        account.setCurrency(currencyRepository.getCurrencyByNameLike(account.getCurrency().getName())
                .orElseThrow(() -> new EntityNotFoundException("Currency not found")));
        account.setFrozen(false);
        account.setCreatedAt(LocalDate.now());
        account.setValue(0L);
        accountRepository.save(account);
    }

    //    для админа
    public void deleteAccountById(Long id) {
        accountRepository.deleteById(id);
    }

    public void updateClientsAccountById(Long idAcc, Long idCl, AccountRequestDto accountRequestDto) {
        Account account = accountRepository.findAccountByIdAndByClientId(idAcc, idCl)
                .orElseThrow(() -> new EntityNotFoundException("Account not found"));
        modelMapper.map(accountRequestDto, account);
        account.setUpdatedAt(LocalDate.now());
        accountRepository.save(account);
    }

    private Account findOrThrow(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Account not found"));
    }
}