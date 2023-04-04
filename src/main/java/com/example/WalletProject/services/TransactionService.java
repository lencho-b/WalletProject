package com.example.WalletProject.services;

import com.example.WalletProject.integration.CurrencyRate;
import com.example.WalletProject.integration.Rate;
import com.example.WalletProject.models.DTO.transaction.TransactionDto;
import com.example.WalletProject.models.DTO.transaction.TransactionRequestDto;
import com.example.WalletProject.models.DTO.transaction.TransactionShortDto;
import com.example.WalletProject.models.DTO.transaction.TransactionTypeDto;
import com.example.WalletProject.models.Entity.Account;
import com.example.WalletProject.models.Entity.Transaction;
import com.example.WalletProject.models.Entity.TransactionAccount;
import com.example.WalletProject.models.Entity.TransactionType;
import com.example.WalletProject.repositories.*;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionAccountRepository transactionAccountRepository;
    private final TransactionTypeRepository transactionTypeRepository;
    private final AccountRepository accountRepository;
    private final CurrencyRepository currencyRepository;
    private final CurrencyService currencyService;
    private final ModelMapper modelMapper;

    public TransactionService(TransactionRepository transactionRepository, TransactionAccountRepository transactionAccountRepository, TransactionTypeRepository transactionTypeRepository, AccountRepository accountRepository, ModelMapper modelMapper, CurrencyRepository currencyRepository, CurrencyService currencyService) {
        this.transactionRepository = transactionRepository;
        this.transactionAccountRepository = transactionAccountRepository;
        this.transactionTypeRepository = transactionTypeRepository;
        this.accountRepository = accountRepository;
        this.modelMapper = modelMapper;
        this.currencyRepository = currencyRepository;
        this.currencyService = currencyService;
    }


    @Transactional(readOnly = true)
    public List<TransactionShortDto> getAllByAccountId(Long accountId) {
        return transactionRepository.findAllByAccountId(accountId)
                .stream()
                .map(entity -> modelMapper.map(entity, TransactionShortDto.class))
                .toList();
    }

    @Transactional(readOnly = true)
    public TransactionDto getOneTransactionById(Long accountId, Long transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new EntityNotFoundException("Transaction not found"));

        accountRepository.findById(accountId)
                .orElseThrow(() -> new EntityNotFoundException("Account not found"));

        transactionAccountRepository
                .findByTransactionIdAndAccountId(transactionId, accountId)
                .orElseThrow(() -> new EntityNotFoundException("This transaction does not belongs to current account"));

        return modelMapper.map(transaction, TransactionDto.class);
    }

    @Transactional
    public TransactionDto saveNewTransactionInRepo(Long clientIdFrom, TransactionRequestDto transactionRequestDto) throws IOException {
        Account account1 = accountRepository.findById(clientIdFrom)
                .orElseThrow(() -> new EntityNotFoundException("Account not found"));
        Account account2 = accountRepository.findById(transactionRequestDto.getAccountIdTo())
                .orElseThrow(() -> new EntityNotFoundException("Account not found"));
        TransactionType transactionType = transactionTypeRepository.findTransactionTypeByType(transactionRequestDto.getTypeName())
                .orElseThrow(() -> new EntityNotFoundException("Type " + transactionRequestDto.getTypeName() + " does not exist"));
        Long transactionValue = transactionRequestDto.getValue().longValue();

        Rate rateForFirstAccount = foundRateForCurrency(account1);
        Rate rateForSecondAccount = foundRateForCurrency(account2);

        if (account1.getValue() < transactionValue) {
            throw new RuntimeException("Operation closed, you have not enough money");
        } else {
            account1.setValue(account1.getValue() - transactionValue);
            accountRepository.save(account1);
        }

        Transaction savedTransaction = createNewTransaction(
                transactionValue, transactionRequestDto.getMessage()
                , transactionType
                , new Date());

        createTransactionAccount(account1, true, savedTransaction);
        createTransactionAccount(account2, false, savedTransaction);

        account2.setValue(account2.getValue() + currencyService.exchangeValue(
                transactionValue
                , rateForFirstAccount
                , rateForSecondAccount).longValue());
        accountRepository.save(account2);

        savedTransaction.setFinishDateTime(new Date());
        savedTransaction.setStatus(true);
        return modelMapper.map(updateTransactionInRepo(savedTransaction), TransactionDto.class);
    }

    private Transaction updateTransactionInRepo(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    private Transaction createNewTransaction(Long value, String message, TransactionType transactionType, Date date) {
        Transaction transaction = new Transaction();
        transaction.setValue(value);
        transaction.setMessage(message);
        transaction.setTransactionType(transactionType);
        transaction.setStartDateTime(date);
        transaction.setStatus(false);
        return transactionRepository.save(transaction);
    }

    private TransactionAccount createTransactionAccount(Account account, Boolean sender, Transaction transaction) {
        TransactionAccount transactionAccount = new TransactionAccount();
        transactionAccount.setAccount(account);
        transactionAccount.setSender(sender);
        transactionAccount.setTransaction(transaction);
        transactionAccountRepository.save(transactionAccount);
        return transactionAccount;
    }

    private Rate foundRateForCurrency(Account account) throws IOException {
        if (currencyRepository.findById(account.getCurrency().getId()).get().getName().compareTo("BYN") == 0) {
            return new Rate(1, "BYN", 1, "Беларусский Рубль", new BigDecimal(1));
        } else {
            return CurrencyRate.showRate(currencyRepository.findById(account.
                    getCurrency().getId()).orElseThrow().getIdFromApi());
        }
    }

    public List<TransactionTypeDto> getAllTransactionTypesFromRepo() {
        return transactionTypeRepository.findAll()
                .stream()
                .map(e -> modelMapper.map(e, TransactionTypeDto.class))
                .toList();
    }
}
