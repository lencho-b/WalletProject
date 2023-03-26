package com.example.WalletProject.controllers;

import com.example.WalletProject.models.DTO.FullTransactionInfoDto;
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
    public FullTransactionInfoDto createNewTransaction() {
        FullTransactionInfoDto fullTransactionInfoDto = new FullTransactionInfoDto();
        fullTransactionInfoDto.setValue(new BigDecimal("0.00"));
        fullTransactionInfoDto.setMessage("введите сообщение");
        fullTransactionInfoDto.setTypeName("перевод");
        return fullTransactionInfoDto;
    }

    // в методе создания транзакции нужен айди счета.
//     создать для этого метода дто формы для перевода.
    @PostMapping("/new")
    public Transaction saveNewTransaction(@PathVariable("idAcc") Long accountIdFrom,
                                          @RequestBody FullTransactionInfoDto fullTransactionInfoDto) {
        //поменять на дто
        return transactionService.saveNewTransactionInRepo(accountIdFrom, fullTransactionInfoDto);
    }
}
