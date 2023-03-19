package com.example.WalletProject.models.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link com.example.WalletProject.models.Entity.Document} entity
 */
public class DocumentRequestDto implements Serializable {
    @Size(max = 50)
    @NotNull
    private final String documentNumber;
    @NotNull
    private final LocalDate issueDate;
    @NotNull
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