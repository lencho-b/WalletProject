package com.example.WalletProject.models.DTO;

import java.time.LocalDate;

public class DocumentResponseDto
{
    private String documentNumber;
    private LocalDate issueDate;
    private Integer countryId;

    public DocumentResponseDto(String documentNumber, LocalDate issueDate, Integer countryId) {
        this.documentNumber = documentNumber;
        this.issueDate = issueDate;
        this.countryId = countryId;
    }

    public DocumentResponseDto() {
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
