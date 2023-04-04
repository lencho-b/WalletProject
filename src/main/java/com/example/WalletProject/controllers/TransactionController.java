package com.example.WalletProject.controllers;

import com.example.WalletProject.models.DTO.transaction.TransactionDto;
import com.example.WalletProject.models.DTO.transaction.TransactionRequestDto;
import com.example.WalletProject.models.DTO.transaction.TransactionShortDto;
import com.example.WalletProject.models.Entity.Transaction;
import com.example.WalletProject.services.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/{idAcc}/transaction")
public class TransactionController {


    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<TransactionShortDto> getAllByAccountId(@PathVariable("idAcc") Long accountId) {
        return transactionService.getAllByAccountId(accountId);
    }

    @GetMapping("/{id}")
    public TransactionDto getTransactionDtoForClientById(@PathVariable("idAcc") Long accountId,
                                                         @PathVariable("id") Long transactionId) {
        return transactionService.getOneTransactionById(accountId, transactionId);
    }

    @PostMapping
    public Transaction saveNewTransaction(@PathVariable("idAcc") Long accountIdFrom,
                                          @RequestBody TransactionRequestDto transactionRequestDto) throws IOException {
        //поменять на дто
        return transactionService.saveNewTransactionInRepo(accountIdFrom, transactionRequestDto);
    }


    //добавить метод, возвращающий лист типов транзакций
}
