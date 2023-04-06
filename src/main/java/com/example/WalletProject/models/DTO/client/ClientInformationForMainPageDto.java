package com.example.WalletProject.models.DTO.client;

import com.example.WalletProject.Messages;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

public class ClientInformationForMainPageDto {
    @NotBlank(message = Messages.EMPTY_FIRSTNAME)
    @Pattern(regexp = "[a-zа-я]", flags = Pattern.Flag.CASE_INSENSITIVE, message = Messages.INVALID_FIRSTNAME)
    private String firstname;
    @NotBlank(message = Messages.EMPTY_LASTNAME)
    @Pattern(regexp = "[a-zа-я]", flags = Pattern.Flag.CASE_INSENSITIVE, message = Messages.INVALID_LASTNAME)
    private  String lastname;
    @Pattern(regexp = "[a-zа-я]", flags = Pattern.Flag.CASE_INSENSITIVE)
    private  String patronymic;
    @NotBlank(message = Messages.EMPTY_DATE_OF_BIRTH)
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private  LocalDate dateOfBirth;
    @NotBlank(message = Messages.EMPTY_EMAIL)
    @Email(message = Messages.INVALID_EMAIL_FORMAT)
    private  String email;
    @NotBlank(message = Messages.EMPTY_PHONE_NUMBER)
    @Pattern(regexp = "[0-9]", message = Messages.INVALID_PHONE_NUMBER)
    private String phoneNumber;


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