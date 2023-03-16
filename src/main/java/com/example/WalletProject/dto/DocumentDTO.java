package com.example.WalletProject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class DocumentDTO {
    @NotBlank(message = "Enter document number")
    private String documentNumber;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date issueDate;
    @NotNull(message = "Select country")
    private CountryDTO countryDTO;

}
