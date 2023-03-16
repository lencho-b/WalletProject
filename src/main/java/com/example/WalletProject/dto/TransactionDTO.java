package com.example.WalletProject.dto;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionDTO {
    @NotNull
    @Min(value = 0)
    private BigDecimal value;
    @Max(value = 150, message = "Max size of comment = 150 characters")
    private String message;

    private boolean status;
    @NotNull
    private TransactionTypeDTO type;


}
