package com.example.WalletProject.controllers;

import com.example.WalletProject.models.DTO.TransactionDto;
import com.example.WalletProject.models.DTO.TransactionRequestDto;
import com.example.WalletProject.models.DTO.TransactionShortDto;
import com.example.WalletProject.models.Entity.Transaction;
import com.example.WalletProject.services.TransactionService;
import org.springframework.web.bind.annotation.*;

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

    //взять админские дто для получения транзакций, только их переименовать.
    @GetMapping("/{id}")
    public TransactionDto getTransactionDtoForClientById(@PathVariable("idAcc") Long accountId,
                                                         @PathVariable("id") Long transactionId) {
        return transactionService.getOneTransactionById(accountId, transactionId);
    }

    // в методе создания транзакции нужен айди счета.
//     создать для этого метода дто формы для перевода.
    @PostMapping
    public Transaction saveNewTransaction(@PathVariable("idAcc") Long accountIdFrom,
                                          @RequestBody TransactionRequestDto transactionRequestDto) {
        //поменять на дто
        return transactionService.saveNewTransactionInRepo(accountIdFrom, transactionRequestDto);
    }
}
