package com.example.WalletProject.models.DTO;

import java.time.LocalDate;
// так как информация получается извне и сохраняется в базе, поля должны быть валидированы
public class ClientInformationForMainPageDTO{

    private final String firstname;

    private final String lastname;

    private final String patronymic;

    private final LocalDate dateOfBirth;

    private final String email;

    private final String phoneNumber;
//нужен ли гига-конструктор - тоже вопрос
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
    // нужен ли toString-?
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