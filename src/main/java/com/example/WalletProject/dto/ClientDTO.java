package com.example.WalletProject.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

//сделала примеры дто
public class ClientDTO {

    @NotBlank(message = "Enter firstname")
    @Size(min = 2, max = 30, message = "Firstname should be between 2 and 30 characters")
    private String firstName;
    @NotBlank(message = "Enter lastname")
    @Size(min = 2, max = 30, message = "Lastname should be between 2 and 30 characters")
    private String lastname;
    @NotBlank(message = "Enter lastname")
    @Size(min = 2, max = 30, message = "Lastname should be between 2 and 30 characters")
    private String patronymic;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date dateOfBirth;
    @NotNull(message = "Enter your email")
    @Email(message = "Email format is not valid")
    private String email;
    @NotNull
    private String phoneNumber;
    @NotNull
    private boolean isVerify;

    private DocumentDTO documentDTO;
}
