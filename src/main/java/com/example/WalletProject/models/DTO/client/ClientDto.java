package com.example.WalletProject.models.DTO.client;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link com.example.WalletProject.models.Entity.Client} entity
 */
public class ClientDto implements Serializable {
    private String firstname;
    private String lastname;
    private String patronymic;
    private LocalDate dateOfBirth;
    private String email;
    private String phoneNumber;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private boolean frozen;
    private boolean isDelete;
    private boolean isVerify;

    public ClientDto() {
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

    public boolean getFrozen() {
        return frozen;
    }

    public boolean getIsDelete() {
        return isDelete;
    }

    public boolean getIsVerify() {
        return isVerify;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
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
                "isVerify = " + isVerify + ")";
    }
}