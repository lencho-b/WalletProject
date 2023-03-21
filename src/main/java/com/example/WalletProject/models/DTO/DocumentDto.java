package com.example.WalletProject.models.DTO;

import java.time.LocalDate;

public class DocumentDto {
    private final String documentNumber;
    private final LocalDate issueDate;
    private final Integer countryId;

    public DocumentDto(String documentNumber, LocalDate issueDate, Integer countryId) {
        this.documentNumber = documentNumber;
        this.issueDate = issueDate;
        this.countryId = countryId;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }
    public LocalDate getIssueDate() {
        return issueDate;
    }
    public Integer getCountryId() {
        return countryId;
    }

}