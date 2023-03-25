package com.example.WalletProject.services;

import com.example.WalletProject.models.Entity.Transaction;
import com.example.WalletProject.repositories.TransactionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final ModelMapper modelMapper;

    public TransactionService(TransactionRepository transactionRepository, ModelMapper modelMapper) {
        this.transactionRepository = transactionRepository;
        this.modelMapper = modelMapper;
    }

//    public TransactionForClientDTO getTransactionForClientById(Long transactionId) {
//        Optional<Transaction> transaction = transactionRepository.findById(transactionId);
//        return modelMapper.map(transaction.orElse(new Transaction()),  TransactionForClientDTO.class);
//    }
}
