package com.example.WalletProject.services;

import com.example.WalletProject.integration.CurrencyRate;
import com.example.WalletProject.integration.Rate;
import com.example.WalletProject.models.DTO.TransactionDto;
import com.example.WalletProject.models.DTO.TransactionRequestDto;
import com.example.WalletProject.models.DTO.TransactionShortDto;
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


    // тут поменяю на дто
    @Transactional(readOnly = true)
    public List<TransactionShortDto> getAllByAccountId(Long accountId) {
        return transactionRepository.findAllByAccountId(accountId)
                .stream()
                .map(entity -> modelMapper.map(entity, TransactionShortDto.class))
                .toList();
    }

    //тут я поменяю на дто когда будет дто
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

    // тут тоже поменяю на дто когда оно будет+ тут по хорошему причесать код надо
    @Transactional
    public Transaction saveNewTransactionInRepo(Long clientIdFrom, TransactionRequestDto transactionRequestDto) throws IOException {
        Account account1 = accountRepository.findById(clientIdFrom)
                .orElseThrow(() -> new EntityNotFoundException("Account not found"));
        Account account2 = accountRepository.findById(transactionRequestDto.getAccountIdTo())
                .orElseThrow(() -> new EntityNotFoundException("Account not found"));
        TransactionType transactionType = transactionTypeRepository.findTransactionTypeByType(transactionRequestDto.getType())
                .orElseThrow(() -> new EntityNotFoundException("Type " + transactionRequestDto.getType() + " does not exist"));
        Long transactionValue = transactionRequestDto.getValue().longValue();

            Rate rateForFirstAccount = foundRateForCurrency(account1);
            Rate rateForSecondAccount = foundRateForCurrency(account2);
        //этот код уйдет когда будет валидация
        if (account1.getValue() < transactionValue || transactionValue < 0) {
            throw new RuntimeException("Operation closed, transfer sum cannot be negative or you have not enough money");
        } else {
            account1.setValue(account1.getValue() - transactionValue);
            accountRepository.save(account1);
        }
                //создаем транзакцию (сохраняем в копейках, можно сделать еще билдер (но я не уверен делают ли билдер в ентити)
        Transaction savedTransaction = createNewTransaction(
                transactionValue, transactionRequestDto.getMessage()
                ,transactionType
                ,new Date());

        //привязываем транзакцию к аккаунтам
        createTransactionAccount(account1, true, savedTransaction);
        createTransactionAccount(account2, false, savedTransaction);

        //увеличиваем счет у второго аккаунта
        account2.setValue(account2.getValue() + currencyService.exchangeValue(
                 transactionValue
                ,rateForFirstAccount
                ,rateForSecondAccount).longValue());
        accountRepository.save(account2);

        //завершаем создание транзакции
        savedTransaction.setFinishDateTime(new Date());
        savedTransaction.setStatus(true);
        return updateTransactionInRepo(savedTransaction);
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
        if (currencyRepository.findById(account.getCurrency().getId()).get().getName().compareTo("BYN")==0)
        {
            return new Rate(1,"BYN",1,"Беларусский Рубль",new BigDecimal(1));
        }
        else {
            return CurrencyRate.showRate(currencyRepository.findById(account.
                    getCurrency().getId()).orElseThrow().getIdFromApi());
        }
    }
}
