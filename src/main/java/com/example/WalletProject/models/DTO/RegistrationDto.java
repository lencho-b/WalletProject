package com.example.WalletProject.models.DTO;

import java.time.LocalDate;

// валидация нужна
public class RegistrationDto {

    private String firstname;

    private String lastname;

    private String patronymic;

    private LocalDate dateOfBirth;

    private String email;

    private String phoneNumber;
    // убираем логин, если его нет в базе.
    private String login;

    private String password;
    // роль пользователь себе выбирать не может, это надо в сервисе проставлять.
    private Integer role;

    public RegistrationDto(String firstname, String lastname, String patronymic, LocalDate dateOfBirth, String email, String phoneNumber, String login, String password, Integer role) {
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

    public Integer getRole() {
        return role;
    }
}
