package com.example.WalletProject.DTO;

import java.time.LocalDate;

public class DocumentDTO {
    private final String documentNumber;
    private final LocalDate issueDate;
    private final Integer countryId;

    public DocumentDTO(String documentNumber, LocalDate issueDate, Integer countryId) {
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

//    @Override
//    public String toString() {
//        return "DocumentDTO{" +
//                "documentNumber='" + documentNumber + '\'' +
//                ", issueDate=" + issueDate +
//                ", countryId=" + countryId +
//                '}';
//    }
}