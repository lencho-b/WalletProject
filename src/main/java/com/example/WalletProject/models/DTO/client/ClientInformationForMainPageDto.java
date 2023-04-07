package com.example.WalletProject.models.DTO.client;

import com.example.WalletProject.Messages;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

public class ClientInformationForMainPageDto {
    @NotBlank(message = Messages.EMPTY_FIRSTNAME)
    @Pattern(regexp = "^[а-яА-Я]+$", flags = Pattern.Flag.CASE_INSENSITIVE, message = Messages.INVALID_FIRSTNAME)
    private String firstname;
    @NotBlank(message = Messages.EMPTY_LASTNAME)
    @Pattern(regexp = "^[а-яА-Я]+$", flags = Pattern.Flag.CASE_INSENSITIVE, message = Messages.INVALID_LASTNAME)
    private  String lastname;
    @Pattern(regexp = "^[а-яА-Я]+$", flags = Pattern.Flag.CASE_INSENSITIVE)
    private  String patronymic;
    @JsonFormat(pattern = "dd.MM.yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private  LocalDate dateOfBirth;
    @NotBlank(message = Messages.EMPTY_EMAIL)
    @Email(message = Messages.INVALID_EMAIL_FORMAT)
    private  String email;
    @NotBlank(message = Messages.EMPTY_PHONE_NUMBER)
    @Pattern(regexp = "^\\d+$", message = Messages.INVALID_PHONE_NUMBER)
    private String phoneNumber;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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