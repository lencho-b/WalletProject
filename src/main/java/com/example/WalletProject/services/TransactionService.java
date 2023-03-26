package com.example.WalletProject.services;

import com.example.WalletProject.models.DTO.FullTransactionInfoDto;
import com.example.WalletProject.models.Entity.Account;
import com.example.WalletProject.models.Entity.Transaction;
import com.example.WalletProject.models.Entity.TransactionAccount;
import com.example.WalletProject.models.Entity.TransactionType;
import com.example.WalletProject.repositories.AccountRepository;
import com.example.WalletProject.repositories.TransactionAccountRepository;
import com.example.WalletProject.repositories.TransactionRepository;
import com.example.WalletProject.repositories.TransactionTypeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionAccountRepository transactionAccountRepository;
    private final TransactionTypeRepository transactionTypeRepository;
    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    public TransactionService(TransactionRepository transactionRepository, TransactionAccountRepository transactionAccountRepository, TransactionTypeRepository transactionTypeRepository, AccountRepository accountRepository, ModelMapper modelMapper) {
        this.transactionRepository = transactionRepository;
        this.transactionAccountRepository = transactionAccountRepository;
        this.transactionTypeRepository = transactionTypeRepository;
        this.accountRepository = accountRepository;
        this.modelMapper = modelMapper;
    }


    // тут поменяю на дто
    @Transactional(readOnly = true)
    public List<Transaction> getAllByAccountId(Long accountId) {
        return transactionRepository.findAllByAccountId(accountId);
    }

    //тут я поменяю на дто когда будет дто
    @Transactional(readOnly = true)
    public Transaction getOneTransactionById(Long accountId, Long transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId).orElse(null);
        if (transaction == null) throw new RuntimeException();

        Account account = accountRepository.findById(accountId).orElse(null);
        if (account == null) throw new RuntimeException();

        TransactionAccount transactionAccount = transactionAccountRepository.findByTransactionIdAndAccountId(transactionId, accountId).orElse(null);
        if (transactionAccount == null) throw new RuntimeException();

        return transaction;
    }

    // тут тоже поменяю на дто когда оно будет+ тут по хорошему причесать код надо
    @Transactional
    public Transaction saveNewTransactionInRepo(Long clientIdFrom, FullTransactionInfoDto transactionInfoDto) {
        Account account1 = accountRepository.findById(clientIdFrom).orElse(null);
        Account account2 = accountRepository.findById(transactionInfoDto.getAccountIdTo()).orElse(null);
        // надо добавить исключение данного типа
        if (account1 == null || account2 == null) throw new RuntimeException();

        TransactionType transactionType = transactionTypeRepository.findTransactionTypeByType(transactionInfoDto.getTypeName()).orElse(null);
        if ((transactionType == null)) throw new RuntimeException();


        Long transactionValue = transactionInfoDto.getValue().multiply(BigDecimal.valueOf(100)).longValue();
        /* проверяем есть ли у клиента заявленная сумма и вычитаем деньги с его счета если нет, кидаем исключение
        если есть то замораживаем средства на счете*/
        if (account1.getValue() < transactionValue) {
            throw new RuntimeException();
        } else {
            Long val1 = account1.getValue();
            account1.setValue(val1 - transactionValue);
            accountRepository.save(account1);
        }

        //создаем транзакцию
        Transaction transaction = new Transaction();
        // как сохраняем ?
        transaction.setValue(transactionInfoDto.getValue().multiply(BigDecimal.valueOf(100)).longValue());
        transaction.setMessage(transactionInfoDto.getMessage());
/*         по сути это поле должно принадлежать к сущности transactionAccount,
         потому что для одного клиента тип транзакции = перевод, для второго - получение (к обсуждению)*/
        transaction.setTransactionType(transactionType);
        transaction.setStartDateTime(new Date());
        transaction.setStatus(false);
        Transaction savedTransaction = transactionRepository.save(transaction);

        //привязываем транзакцию к аккаунтам
        TransactionAccount transactionAccount1 = new TransactionAccount();
        TransactionAccount transactionAccount2 = new TransactionAccount();

        transactionAccount1.setAccount(account1);
        transactionAccount1.setSender(true);
        transactionAccount1.setTransaction(savedTransaction);

        transactionAccount2.setAccount(account2);
        transactionAccount2.setSender(false);
        transactionAccount2.setTransaction(savedTransaction);

        transactionAccountRepository.save(transactionAccount1);
        transactionAccountRepository.save(transactionAccount2);

        //увеличиваем счет у второго аккаунта
        account2.setValue(account2.getValue() + transaction.getValue());
        accountRepository.save(account2);

        //завершаем создание транзакции
        savedTransaction.setFinishDateTime(new Date());
        savedTransaction.setStatus(true);
        return transactionRepository.save(savedTransaction);
    }
}
