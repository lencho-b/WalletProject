package com.example.WalletProject.models.DTO;

import com.example.WalletProject.Messages;
import com.example.WalletProject.models.DTO.country.CountryDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class DocumentDto {

    @Pattern(regexp = "[a-z]{2}[0-9]{7}", flags = Pattern.Flag.CASE_INSENSITIVE, message = Messages.INVALID_DOCUMENT_NUMBER)
    @NotNull(message = Messages.EMPTY_DOCUMENT_NUMBER)
    private  String documentNumber;
    @NotBlank(message = Messages.EMPTY_ISSUE_DATE)
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private  LocalDate issueDate;
    //меняем айди на название страны.
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