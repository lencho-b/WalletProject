package com.example.WalletProject.models.DTO;


import jakarta.validation.constraints.NotBlank;

//валидация нужна
public class CountryForAdminDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String phoneCode;
    @NotBlank
    private String documentFormat;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public String getDocumentFormat() {
        return documentFormat;
    }

    public void setDocumentFormat(String documentFormat) {
        this.documentFormat = documentFormat;
    }
}
