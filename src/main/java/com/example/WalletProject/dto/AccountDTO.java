package com.example.WalletProject.dto;



import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigInteger;
import java.util.Date;

public class AccountDTO {
    @NotBlank(message = "Enter name of account")
    private String name;
    @NotNull
    private boolean status;
    @Max(value = 200, message = "Max size of comment = 200 characters")
    private String comment;
    @Min(value = 0)
    private BigInteger value;//не уверена, что отрицательный баланс недопустим, поменяйте, если возражаете.
    @NotNull
    private ClientDTO clientDTO;
    @NotNull(message = "Select currency")
    private CurrencyDTO currencyDTO;

}
