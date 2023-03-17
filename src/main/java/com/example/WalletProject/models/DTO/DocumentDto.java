package com.example.WalletProject.models.DTO;

import com.example.WalletProject.models.Entity.Country;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link com.example.WalletProject.models.Entity.Document} entity
 */
public class DocumentDto implements Serializable {
    private final Long id;
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
    private final Country country;

    public DocumentDto(Long id, String documentNumber, LocalDate issueDate, LocalDate createdAt, LocalDate updatedAt, Country country) {
        this.id = id;
        this.documentNumber = documentNumber;
        this.issueDate = issueDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.country = country;
    }

    public Long getId() {
        return id;
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

    public Country getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentDto entity = (DocumentDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.documentNumber, entity.documentNumber) &&
                Objects.equals(this.issueDate, entity.issueDate) &&
                Objects.equals(this.createdAt, entity.createdAt) &&
                Objects.equals(this.updatedAt, entity.updatedAt) &&
                Objects.equals(this.country, entity.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, documentNumber, issueDate, createdAt, updatedAt, country);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "documentNumber = " + documentNumber + ", " +
                "issueDate = " + issueDate + ", " +
                "createdAt = " + createdAt + ", " +
                "updatedAt = " + updatedAt + ", " +
                "country = " + country + ")";
    }
}