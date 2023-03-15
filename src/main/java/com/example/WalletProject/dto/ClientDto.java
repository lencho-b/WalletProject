package com.example.WalletProject.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link com.example.WalletProject.models.Client} entity
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
    private final Boolean status;
    @NotNull
    private final Boolean isVerify;


    public ClientDto(Long id, String firstname, String lastname, String patronymic, LocalDate dateOfBirth, String email, String phoneNumber, LocalDate createdAt, Boolean status, Boolean isVerify) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.createdAt = createdAt;
        this.status = status;
        this.isVerify = isVerify;
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

    public Boolean getStatus() {
        return status;
    }

    public Boolean getIsVerify() {
        return isVerify;
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
                Objects.equals(this.status, entity.status) &&
                Objects.equals(this.isVerify, entity.isVerify);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, patronymic, dateOfBirth, email, phoneNumber, createdAt, status, isVerify);
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
                "status = " + status + ", " +
                "isVerify = " + isVerify + ")";
    }
}