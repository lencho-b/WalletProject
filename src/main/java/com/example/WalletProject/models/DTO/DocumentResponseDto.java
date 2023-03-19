package com.example.WalletProject.models.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDate;

public class DocumentResponseDto implements Serializable
{
    @Size(max = 50)
    @NotNull
    private String documentNumber;
    @NotNull
    private LocalDate issueDate;
    @NotNull
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
