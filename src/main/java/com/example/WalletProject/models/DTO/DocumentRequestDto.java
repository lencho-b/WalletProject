package com.example.WalletProject.models.DTO;

import java.time.LocalDate;

public class DocumentRequestDto{
    private final String documentNumber;
    private final LocalDate issueDate;
    private final Integer countryId;

    public DocumentRequestDto(String documentNumber, LocalDate issueDate, LocalDate createdAt, LocalDate updatedAt, Integer countryId) {
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