package com.example.WalletProject.models.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

//валидация нужна
public class DocumentDto {

    @Pattern(regexp = "[a-z]{2}[0-9]{7}", flags = Pattern.Flag.CASE_INSENSITIVE)
    private final String documentNumber;
    @NotBlank
    private final LocalDate issueDate;
    //меняем айди на название страны.
    @NotEmpty
    private CountryNameDTO country;

    public DocumentDto(String documentNumber, LocalDate issueDate, CountryNameDTO country) {
        this.documentNumber = documentNumber;
        this.issueDate = issueDate;
        this.country = country;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public CountryNameDTO getCountry() {
        return country;
    }

    public void setCountry(CountryNameDTO country) {
        this.country = country;
    }
}