package com.example.WalletProject.controllers;

import com.example.WalletProject.models.DTO.transaction.TransactionDto;
import com.example.WalletProject.models.DTO.transaction.TransactionRequestDto;
import com.example.WalletProject.models.DTO.transaction.TransactionShortDto;
import com.example.WalletProject.models.DTO.transaction.TransactionTypeDto;
import com.example.WalletProject.services.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{idAcc}/")
public class TransactionController {


    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/transaction")
    public List<TransactionShortDto> getAllByAccountId(@PathVariable("idAcc") Long accountId) {
        return transactionService.getAllByAccountId(accountId);
    }

    @GetMapping("/transaction/{id}")
    public TransactionDto getTransactionDtoForClientById(@PathVariable("idAcc") Long accountId,
                                                         @PathVariable("id") Long transactionId) {
        return transactionService.getOneTransactionById(accountId, transactionId);
    }

    @PostMapping("/transaction")
    public TransactionDto saveNewTransaction(@PathVariable("idAcc") Long accountIdFrom,
                                          @RequestBody TransactionRequestDto transactionRequestDto) {
        return transactionService.saveNewTransactionInRepo(accountIdFrom, transactionRequestDto);
    }

    @GetMapping("/transaction-type")
    public List<TransactionTypeDto> getAllTransactionTypes() {
        return transactionService.getAllTransactionTypesFromRepo();
    }
}
