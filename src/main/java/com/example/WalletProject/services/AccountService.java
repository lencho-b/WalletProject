package com.example.WalletProject.services;

import com.example.WalletProject.models.DTO.AccountDto;
import com.example.WalletProject.models.DTO.AccountRequestDto;
import com.example.WalletProject.models.Entity.Account;
import com.example.WalletProject.repositories.AccountRepository;
import com.example.WalletProject.repositories.ClientRepository;
import com.example.WalletProject.repositories.CurrencyRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream()
                .map(account -> new AccountDto(
                        account.getName(),
                        account.getFrozen(),
                        account.getComment(),
                        account.getValue(),
                        account.getCurrency().getName()))
                .collect(Collectors.toList());
    }

    //
    public List<Account> getClientsAccounts(Long id) {
        List<Account> accounts = accountRepository.findAll();
        List<Account> clientsAccounts = new ArrayList<>();
        for (Account acc : accounts) {
            if (acc.getClient().getId() == (long) id) {
                clientsAccounts.add(acc);
            }
        }
        return clientsAccounts;
    }

    //    для админа
    // лямбда не требуется
    // зачем метод, если он не используется? Плюс Optional
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id).get();
        return new AccountDto(
                account.getName(),
                account.getFrozen(),
                account.getComment(),
                account.getValue(),
                account.getCurrency().getName());
    }

    // решили сделать query. Доставать абсолютно все счета из базы - плохая практика.
    public AccountDto getClientsAccountById(Long idAcc, Long idCl) {
        List<Account> clientsAccounts = getClientsAccounts(idCl);
        Optional<Account> accountOptional = clientsAccounts
                .stream()
                .filter(a -> a.getId().equals(idAcc))
                .findFirst();
        return accountOptional
                .map(account -> new AccountDto(
                                account.getName(),
                                account.getFrozen(),
                                account.getComment(),
                                account.getValue(),
                                account.getCurrency().getName()
                        )
                )
                .orElse(null);
    }

    public List<AccountDto> getAllAccountsByClientId(Long id) {
        //в репозитории есть другой метод для этого. Доставать все счета из базы - плохая практика.
        return accountRepository.findAll()
                .stream()
                .filter(account -> account.getClient().getId() == (long) id)
                .map(account -> new AccountDto(
                        account.getName(),
                        account.getFrozen(),
                        account.getComment(),
                        account.getValue(),
                        account.getCurrency().getName()
                ))
                .collect(Collectors.toList());
    }

    public void createAccountByClientId(AccountDto accountDto, Long id) {
        Account account = new Account();
        account.setComment(accountDto.getComment());
        account.setName(accountDto.getName());
        account.setValue(0L);
        account.setCreatedAt(LocalDate.now());
        account.setFrozen(false);
        account.setUpdatedAt(null);
        //тоже лучше добавить optional
        account.setClient(clientRepository.getById(id));
        account.setCurrency(currencyRepository.getCurrencyByNameLike(accountDto.getCurrencyName()).get());
        accountRepository.save(account);
    }

    //    для админа
    public void deleteAccountById(Long id) {
        accountRepository.deleteById(id);
    }

    public void updateClientsAccountById(Long idAcc, Long idCl, AccountRequestDto accountRequestDto) {
        //optional
        Account account = accountRepository.getById(idAcc);
        if (account.getClient().getId() == (long) idCl) {
            account.setComment(accountRequestDto.getComment());
            account.setName(accountRequestDto.getName());
            account.setUpdatedAt(LocalDate.now());
            accountRepository.save(account);
        }
    }
}