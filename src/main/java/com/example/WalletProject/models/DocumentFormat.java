package com.example.WalletProject.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "document_format")
public class DocumentFormat {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "document_format", length = Integer.MAX_VALUE)
    private String documentFormat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocumentFormat() {
        return documentFormat;
    }

    public void setDocumentFormat(String documentFormat) {
        this.documentFormat = documentFormat;
    }

}