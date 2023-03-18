package com.example.WalletProject.models.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link com.example.WalletProject.models.Entity.Document} entity
 */
public class DocumentDto implements Serializable {
    @Size(max = 50)
    @NotNull
    private final String documentNumber;
    @NotNull
    private final LocalDate issueDate;
    @NotNull
    private final LocalDate createdAt;
    @NotNull
    private final LocalDate updatedAt;
    @NotNull
    private final Integer countryId;

    public DocumentDto(String documentNumber, LocalDate issueDate, LocalDate createdAt, LocalDate updatedAt, Integer countryId) {
        this.documentNumber = documentNumber;
        this.issueDate = issueDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.countryId = countryId;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public Integer getCountryId() {
        return countryId;
    }


    @Override
    public int hashCode() {
        return Objects.hash(documentNumber, issueDate, createdAt, updatedAt, countryId);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "documentNumber = " + documentNumber + ", " +
                "issueDate = " + issueDate + ", " +
                "createdAt = " + createdAt + ", " +
                "updatedAt = " + updatedAt + ", " +
                "country = " + countryId + ")";
    }
}