package com.example.WalletProject.models.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;

//валидация нужна
public class DocumentDto {
    private String documentNumber;
    @NotBlank
    private LocalDate issueDate;
    //меняем айди на название страны.
    @NotEmpty
    private String country;

    public DocumentDto(String documentNumber, LocalDate issueDate, String country) {
        this.documentNumber = documentNumber;
        this.issueDate = issueDate;
        this.country = country;
    }

    public DocumentDto() {
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}