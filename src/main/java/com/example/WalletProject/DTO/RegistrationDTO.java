package com.example.WalletProject.DTO;

import java.time.LocalDate;

public class RegistrationDTO
{

    private  String firstname;

    private  String lastname;

    private  String patronymic;

    private LocalDate dateOfBirth;

    private  String email;

    private String phoneNumber;

    private String login;

    private String password;

    private  Integer role;

    public RegistrationDTO(String firstname, String lastname, String patronymic, LocalDate dateOfBirth, String email, String phoneNumber, String login, String password, Integer role) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public RegistrationDTO() {
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

    public Integer getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "RegistrationDTO{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
