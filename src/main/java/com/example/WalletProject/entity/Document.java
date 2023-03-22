package com.example.WalletProject.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "document")
public class Document {
    @Id
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @Column(name = "client_id", nullable = false)
    private Long client_id;

    @Column(name = "document_number", nullable = false, length = 50)
    private String documentNumber;

    @Column(name = "issue_date", nullable = false)
    private LocalDate issueDate;

    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    public Document(Long client_id, String documentNumber, LocalDate issueDate, LocalDate createdAt, Country country) {
        this.client_id = client_id;
        this.documentNumber = documentNumber;
        this.issueDate = issueDate;
        this.createdAt = createdAt;
        this.country = country;
    }

    public Document() {
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public Long getId() {
        return client_id;
    }

    public void setId(Long id) {
        this.client_id = id;
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Document{" +
                "client_id=" + client_id +
                ", documentNumber='" + documentNumber + '\'' +
                ", issueDate=" + issueDate +
                ", createdAt=" + createdAt +
                ", country=" + country +
                '}';
    }
}