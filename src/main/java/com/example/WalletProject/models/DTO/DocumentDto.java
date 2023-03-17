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
    private final String country;

    public DocumentDto(String documentNumber, LocalDate issueDate, LocalDate createdAt, LocalDate updatedAt, String country) {
        this.documentNumber = documentNumber;
        this.issueDate = issueDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.country = country;
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

    public String getCountry() {
        return country;
    }


    @Override
    public int hashCode() {
        return Objects.hash(documentNumber, issueDate, createdAt, updatedAt, country);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "documentNumber = " + documentNumber + ", " +
                "issueDate = " + issueDate + ", " +
                "createdAt = " + createdAt + ", " +
                "updatedAt = " + updatedAt + ", " +
                "country = " + country + ")";
    }
}