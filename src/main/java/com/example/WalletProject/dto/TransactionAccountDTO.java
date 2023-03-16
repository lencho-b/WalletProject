package com.example.WalletProject.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigInteger;

public class TransactionAccountDTO {
    @NotNull
    private BigInteger AccountId;
    @NotNull
    private TransactionDTO transactionDTO;
    @NotNull
    private boolean sender;
}
