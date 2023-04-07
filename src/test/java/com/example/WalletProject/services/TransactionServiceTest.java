package com.example.WalletProject.services;

import com.example.WalletProject.exceptions.AccountNotFoundException;
import com.example.WalletProject.exceptions.TransactionNotFoundException;
import com.example.WalletProject.integration.Rate;
import com.example.WalletProject.models.DTO.transaction.TransactionDto;
import com.example.WalletProject.models.DTO.transaction.TransactionRequestDto;
import com.example.WalletProject.models.Entity.*;
import com.example.WalletProject.repositories.*;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.catchException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TransactionServiceTest {

    @Mock
    ModelMapper modelMapper;
    @Mock
    TransactionAccountRepository transactionAccountRepository;
    @Mock
    TransactionRepository transactionRepository;
    @Mock
    AccountRepository accountRepository;
    @Mock
    TransactionTypeRepository transactionTypeRepository;
    @Mock
    CurrencyRepository currencyRepository;
    @Mock
    CurrencyService currencyService;
    @InjectMocks
    TransactionService transactionService;

    Currency currency;
    Account account;
    Transaction transaction;
    TransactionAccount transactionAccount;
    TransactionType transactionType;
    TransactionRequestDto transactionRequestDto;

    @BeforeEach
    public void initEach(){
        currency = new Currency();
        currency.setName("byn");

        account = new Account();
        account.setValue(10L);
        account.setCurrency(currency);

        transaction = new Transaction();
        transaction.setId(1L);
        transaction.setValue(1L);

        transactionAccount = new TransactionAccount();
        transactionType = new TransactionType();

        transactionRequestDto = new TransactionRequestDto();
        transactionRequestDto.setAccountIdTo(1L);
        transactionRequestDto.setTypeName("byn");
        transactionRequestDto.setValue(BigDecimal.valueOf(1L));
    }


    @Test
    public void getAllTransaction() {
        List<Transaction> answer = new ArrayList<>();
        when(transactionRepository.findAllByAccountId(any(Long.class))).thenReturn(answer);
        assertThat(transactionService.getAllByAccountId(1L)).isEqualTo(answer);
    }

    @Test
    public void getAllTransactionWhenExceptionThrown_thenAssertThat() {
        assertThatThrownBy(() -> transactionService
                .getAllByAccountId(null))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void getOneTransaction() {
        transactionAccount.setTransaction(transaction);
        transactionAccount.setAccount(account);

        when(transactionRepository.findById(any(Long.class))).thenReturn(Optional.of(transaction));
        when(accountRepository.findById(any(Long.class))).thenReturn(Optional.of(account));
        when(transactionAccountRepository.findByTransactionIdAndAccountId(any(Long.class), any(Long.class))).thenReturn(Optional.of(transactionAccount));
        assertThat(transactionService.getOneTransactionById(1L, 1L)).isEqualTo(modelMapper.map(transaction, TransactionDto.class));
    }

    @Test
    public void getTransactionByIdThrownTransactionNotFound_thenAssertThat() {
        when(transactionRepository.findById(any(Long.class))).thenReturn(Optional.ofNullable(null));
        assertThatThrownBy(() -> transactionService.getOneTransactionById(1L, 1L)).isInstanceOf(TransactionNotFoundException.class);
    }

    @Test
    public void getTransactionByIdThrownAccountNotFound_thenAssertThat() {
        when(transactionRepository.findById(any(Long.class))).thenReturn(Optional.of(transaction));
        when(accountRepository.findById(any(Long.class))).thenReturn(Optional.ofNullable(null));
        assertThatThrownBy(() -> transactionService.getOneTransactionById(1L, 1L)).isInstanceOf(AccountNotFoundException.class);
    }

    @Test
    public void getTransactionByIdThrownTransactionAccountNotFound_thenAssertThat() {
        when(transactionRepository.findById(any(Long.class))).thenReturn(Optional.of(transaction));
        when(accountRepository.findById(any(Long.class))).thenReturn(Optional.ofNullable(account));
        when(transactionAccountRepository.findByTransactionIdAndAccountId(any(Long.class), any(Long.class))).thenReturn(Optional.ofNullable(null));
        assertThatThrownBy(() -> transactionService.getOneTransactionById(1L, 1L)).isInstanceOf(TransactionNotFoundException.class);
    }

    @Test
    public void getAllTransactionType() {
        when(transactionTypeRepository.findAll()).thenReturn(Collections.emptyList());
        assertThat(transactionService.getAllTransactionTypesFromRepo()).isEqualTo(Collections.emptyList());
    }

    @Test
    public void saveTransactionInRepoThrownAccountNotFound_thenAssertThat() {
        assertThatThrownBy(() -> transactionService
                .saveNewTransactionInRepo(1L, new TransactionRequestDto()))
                .isInstanceOf(AccountNotFoundException.class);
    }

    @Test
    public void saveNewTransactionThrownTransactionNotFound_thenAssertThat() {
        when(accountRepository.findById(any(Long.class))).thenReturn(Optional.of(account));
        when(transactionTypeRepository.findTransactionTypeByType(any(String.class))).thenReturn(Optional.empty());

        Throwable throwable = catchException(() -> transactionService.saveNewTransactionInRepo(1L, new TransactionRequestDto()));
        assertThat(throwable.getClass().getSimpleName().equals(TransactionNotFoundException.class.getSimpleName()));
    }

    @Test
    public void saveNewTransactionThrownRuntime_thenAssertThat() {
        account.setValue(1L);
        transaction.setValue(100L);

        when(accountRepository.findById(any(Long.class))).thenReturn(Optional.of(account));

        Throwable throwable = catchException(() -> transactionService.saveNewTransactionInRepo(1L, new TransactionRequestDto()));
        assertThat(throwable.getClass().getSimpleName().equals(RuntimeException.class.getSimpleName()));
    }

    @Test
    public void saveNewTransactionThrownTransactionNotFoundOnUpdate_thenAssertThat() {
        when(accountRepository.findById(any(Long.class))).thenReturn(Optional.of(account));
        when(transactionTypeRepository.findTransactionTypeByType(any(String.class))).thenReturn(Optional.of(transactionType));
        when(transactionRepository.save(any(Transaction.class))).thenReturn(transaction);
        when(transactionAccountRepository.save(any(TransactionAccount.class))).thenReturn(transactionAccount);
        when(currencyRepository.findById(any(Integer.class))).thenReturn(Optional.of(currency));
        when(currencyService.exchangeValue(any(Long.class), any(Rate.class), any(Rate.class))).thenReturn(BigDecimal.ONE);

        Throwable throwable = catchException(() -> transactionService.saveNewTransactionInRepo(1L, transactionRequestDto));
        assertThat(throwable.getClass().getSimpleName().equals(TransactionNotFoundException.class.getSimpleName()));
    }


    @Test
    public void saveNewTransactionThrownTransactionNotFtyhjnound_thenAssertThat() {
        when(accountRepository.findById(any(Long.class))).thenReturn(Optional.of(account));
        when(transactionTypeRepository.findTransactionTypeByType(any(String.class))).thenReturn(Optional.of(transactionType));
        when(transactionRepository.findById(any(Long.class))).thenReturn(Optional.of(transaction));
        when(transactionRepository.save(any(Transaction.class))).thenReturn(transaction);
        when(transactionAccountRepository.save(any(TransactionAccount.class))).thenReturn(transactionAccount);
        when(currencyRepository.findById(any(Integer.class))).thenReturn(Optional.of(currency));
        when(currencyService.exchangeValue(any(Long.class), any(Rate.class), any(Rate.class))).thenReturn(BigDecimal.ONE);
        when(modelMapper.map(any(Transaction.class), any(Class.class))).thenReturn(new TransactionDto());

        assertThat(transactionService.saveNewTransactionInRepo(1L, transactionRequestDto)).isInstanceOf(TransactionDto.class);
    }


}
