package com.example.WalletProject.services;

import com.example.WalletProject.models.DTO.AccountDto;
import com.example.WalletProject.models.DTO.AccountRequestDto;
import com.example.WalletProject.models.Entity.Account;
import com.example.WalletProject.repositories.AccountRepository;
import com.example.WalletProject.repositories.ClientRepository;
import com.example.WalletProject.repositories.CurrencyRepository;
import jakarta.persistence.EntityNotFoundException;
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

    public AccountService(AccountRepository accountRepository, ClientRepository clientRepository, CurrencyRepository currencyRepository) {
        this.accountRepository = accountRepository;
        this.clientRepository = clientRepository;
        this.currencyRepository = currencyRepository;
    }

    //    для админа
    public List<AccountDto> getAllAccounts(Integer numberOfPage) {
        Page<Account> accounts = accountRepository.findAll(PageRequest.of(numberOfPage, 20));
        return accounts.stream()
                .map(account -> new AccountDto(
                        account.getName(),
                        account.getFrozen(),
                        account.getComment(),
                        account.getValue(),
                        account.getCurrency().getName()))
                .collect(Collectors.toList());
    }


    public List<AccountDto> getAllAccountsByClientId(Long id) {
        return accountRepository.findAccountsByClientId(id)
                .stream()
                .map(account -> new AccountDto(
                        account.getName(),
                        account.getFrozen(),
                        account.getComment(),
                        account.getValue(),
                        account.getCurrency().getName()
                ))
                .collect(Collectors.toList());
    }

    public AccountDto getAccountById(Long id) {
        Account account = findOrThrow(id);
        return new AccountDto(
                account.getName(),
                account.getFrozen(),
                account.getComment(),
                account.getValue(),
                account.getCurrency().getName());
    }

    public AccountDto getClientsAccountById(Long idAcc, Long idCl) {
        Account account = accountRepository.findAccountByIdAndByClientId(idAcc, idCl)
                .orElseThrow(() -> new EntityNotFoundException("Account not found"));
        return new AccountDto(
                account.getName(),
                account.getFrozen(),
                account.getComment(),
                account.getValue(),
                account.getCurrency().getName()
        );
    }

    public void createAccountByClientId(AccountDto accountDto, Long id) {
        Account account = new Account();
        account.setComment(accountDto.getComment());
        account.setName(accountDto.getName());
        account.setValue(0L);
        account.setCreatedAt(LocalDate.now());
        account.setFrozen(false);
        account.setUpdatedAt(LocalDate.now());
        account.setClient(clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client not found")));
        account.setCurrency(currencyRepository.getCurrencyByNameLike(accountDto.getCurrencyName())
                .orElseThrow(() -> new EntityNotFoundException("Currency not found")));
        accountRepository.save(account);
    }

    //    для админа
    public void deleteAccountById(Long id) {
        accountRepository.deleteById(id);
    }

    public void updateClientsAccountById(Long idAcc, Long idCl, AccountRequestDto accountRequestDto) {
        Account account = accountRepository.findAccountByIdAndByClientId(idAcc, idCl)
                .orElseThrow(() -> new EntityNotFoundException("Account not found"));
        account.setComment(accountRequestDto.getComment());
        account.setName(accountRequestDto.getName());
        account.setUpdatedAt(LocalDate.now());
        accountRepository.save(account);
    }

    private Account findOrThrow(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Account not found"));
    }
}