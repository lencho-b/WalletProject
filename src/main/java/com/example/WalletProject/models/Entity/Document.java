package com.example.WalletProject.models.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "document")
public class Document {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Size(max = 50)
    @NotNull
    @Column(name = "document_number", nullable = false, length = 50)
    private String documentNumber;

    @NotNull
    @Column(name = "issue_date", nullable = false)
    private LocalDate issueDate;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    @NotNull
    @Column(name = "updated_at", nullable = false)
    private LocalDate updatedAt;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}