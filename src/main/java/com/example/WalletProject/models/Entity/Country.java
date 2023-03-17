package com.example.WalletProject.models.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "country")
public class Country {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Size(max = 50)
    @Column(name = "phone_code", nullable = false, length = 50)
    private String phoneCode;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "document_format", nullable = false)
    private DocumentFormat documentFormat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public DocumentFormat getDocumentFormat() {
        return documentFormat;
    }

    public void setDocumentFormat(DocumentFormat documentFormat) {
        this.documentFormat = documentFormat;
    }

}