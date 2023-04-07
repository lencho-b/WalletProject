package com.example.WalletProject.models.DTO;

import com.example.WalletProject.Messages;
import com.example.WalletProject.models.DTO.country.CountryDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class DocumentDto {

    @NotBlank(message = Messages.EMPTY_DOCUMENT_NUMBER)
    private  String documentNumber;
    @JsonFormat(pattern = "dd.MM.yyyy")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private  LocalDate issueDate;

    @NotNull(message = Messages.EMPTY_COUNTRY_NAME)
    private CountryDto country;


    public String getDocumentNumber() {
        return documentNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public CountryDto getCountry() {
        return country;
    }

    public void setCountry(CountryDto country) {
        this.country = country;
    }
}