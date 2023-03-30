package com.example.WalletProject.controllers;

import com.example.WalletProject.models.DTO.TransactionRequestDto;
import com.example.WalletProject.models.Entity.Transaction;
import com.example.WalletProject.services.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/{idAcc}/transaction")
public class TransactionController {


    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    // переделать на дто
    @GetMapping
    public List<Transaction> getAllByAccountId(@PathVariable("idAcc") Long accountId) {
        return transactionService.getAllByAccountId(accountId);
    }

    //взять админские дто для получения транзакций, только их переименовать.
    @GetMapping("/{id}")
    public Transaction getTransactionDtoForClientById(@PathVariable("idAcc") Long accountId,
                                                      @PathVariable("id") Long transactionId) {
        return transactionService.getOneTransactionById(accountId, transactionId);
    }

    @GetMapping("/new")
    public TransactionRequestDto createNewTransaction() {
        TransactionRequestDto transactionRequestDto = new TransactionRequestDto();
        transactionRequestDto.setValue(new BigDecimal("0.00"));
        transactionRequestDto.setMessage("введите сообщение");
        transactionRequestDto.setTypeName("перевод");
        return transactionRequestDto;
    }

    // в методе создания транзакции нужен айди счета.
//     создать для этого метода дто формы для перевода.
    @PostMapping("/new")
    public Transaction saveNewTransaction(@PathVariable("idAcc") Long accountIdFrom,
                                          @RequestBody TransactionRequestDto transactionRequestDto) {
        //поменять на дто
        return transactionService.saveNewTransactionInRepo(accountIdFrom, transactionRequestDto);
    }
}
