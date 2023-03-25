package com.example.WalletProject.controllers;

import com.example.WalletProject.services.TransactionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/{id}")
    public TransactionForClientDTO getTransactionDtoForClientById(@PathVariable("id") Long transactionId) {
        return transactionService.getTransactionDtoForClientById(transactionId);
    }

    @PatchMapping("/{id}")
    public TransactionForClientDTO updateTransactionById(@PathVariable("id") Long transactionId,
            @Valid @RequestBody TransactionForClientDTO transactionForClientDTO) {
        return transactionService.updateTransactionFromClientById(transactionId, transactionForClientDTO);
    }

    @PostMapping("/new")
    public TransactionForClientDTO saveNewTransaction(@Valid @RequestBody TransactionForClientDTO transactionForClientDTO) {
        return transactionService.saveNewTransactionFromClientInRepo(transactionForClientDTO);
    }
}
