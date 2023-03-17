package com.example.WalletProject.models.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link com.example.WalletProject.models.Entity.Client} entity
 */
public class ClientDto implements Serializable {
    private final Long id;
    @Size(max = 50)
    @NotNull
    private final String firstname;
    @Size(max = 50)
    @NotNull
    private final String lastname;
    @Size(max = 50)
    @NotNull
    private final String patronymic;
    @NotNull
    private final LocalDate dateOfBirth;
    @NotNull
    private final String email;
    @Size(max = 50)
    @NotNull
    private final String phoneNumber;
    @NotNull
    private final LocalDate createdAt;
    @NotNull
    private final LocalDate updatedAt;
    @NotNull
    private final Boolean frozen;
    @NotNull
    private final Boolean isDelete;
    @NotNull
    private final Boolean isVerify;
    private final DocumentDto document;

    public ClientDto(Long id, String firstname, String lastname, String patronymic, LocalDate dateOfBirth, String email, String phoneNumber, LocalDate createdAt, LocalDate updatedAt, Boolean frozen, Boolean isDelete, Boolean isVerify, DocumentDto document) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.frozen = frozen;
        this.isDelete = isDelete;
        this.isVerify = isVerify;
        this.document = document;
    }

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public Boolean getFrozen() {
        return frozen;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public Boolean getIsVerify() {
        return isVerify;
    }

    public DocumentDto getDocument() {
        return document;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDto entity = (ClientDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.firstname, entity.firstname) &&
                Objects.equals(this.lastname, entity.lastname) &&
                Objects.equals(this.patronymic, entity.patronymic) &&
                Objects.equals(this.dateOfBirth, entity.dateOfBirth) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.phoneNumber, entity.phoneNumber) &&
                Objects.equals(this.createdAt, entity.createdAt) &&
                Objects.equals(this.updatedAt, entity.updatedAt) &&
                Objects.equals(this.frozen, entity.frozen) &&
                Objects.equals(this.isDelete, entity.isDelete) &&
                Objects.equals(this.isVerify, entity.isVerify) &&
                Objects.equals(this.document, entity.document);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, patronymic, dateOfBirth, email, phoneNumber, createdAt, updatedAt, frozen, isDelete, isVerify, document);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "firstname = " + firstname + ", " +
                "lastname = " + lastname + ", " +
                "patronymic = " + patronymic + ", " +
                "dateOfBirth = " + dateOfBirth + ", " +
                "email = " + email + ", " +
                "phoneNumber = " + phoneNumber + ", " +
                "createdAt = " + createdAt + ", " +
                "updatedAt = " + updatedAt + ", " +
                "frozen = " + frozen + ", " +
                "isDelete = " + isDelete + ", " +
                "isVerify = " + isVerify + ", " +
                "document = " + document + ")";
    }
}