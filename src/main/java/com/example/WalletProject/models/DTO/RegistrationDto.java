package com.example.WalletProject.models.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class RegistrationDto
{
    @Size(max = 50)
    @NotNull
    private  String firstname;
    @Size(max = 50)
    @NotNull
    private  String lastname;
    @Size(max = 50)
    @NotNull
    private  String patronymic;
    @NotNull
    private LocalDate dateOfBirth;
    @NotNull
    private  String email;
    @Size(max = 50)
    @NotNull
    private String phoneNumber;
    @Size(max = 50)
    @NotNull
    private String login;
    @NotNull
    private String password;

    public RegistrationDto(String firstname, String lastname, String patronymic, LocalDate dateOfBirth, String email, String phoneNumber, String login, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.login = login;
        this.password = password;
    }

    public RegistrationDto() {
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

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
