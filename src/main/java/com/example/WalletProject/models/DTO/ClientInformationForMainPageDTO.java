package com.example.WalletProject.models.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link com.example.WalletProject.models.Entity.Client} entity
 */
public class ClientInformationForMainPageDTO implements Serializable {
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

    public ClientInformationForMainPageDTO(String firstname, String lastname, String patronymic, LocalDate dateOfBirth, String email, String phoneNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientInformationForMainPageDTO entity = (ClientInformationForMainPageDTO) o;
        return Objects.equals(this.firstname, entity.firstname) &&
                Objects.equals(this.lastname, entity.lastname) &&
                Objects.equals(this.patronymic, entity.patronymic) &&
                Objects.equals(this.dateOfBirth, entity.dateOfBirth) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.phoneNumber, entity.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, patronymic, dateOfBirth, email, phoneNumber);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "firstname = " + firstname + ", " +
                "lastname = " + lastname + ", " +
                "patronymic = " + patronymic + ", " +
                "dateOfBirth = " + dateOfBirth + ", " +
                "email = " + email + ", " +
                "phoneNumber = " + phoneNumber + ")";
    }
}