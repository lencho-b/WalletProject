package com.example.WalletProject.models.DTO.country;
import com.example.WalletProject.Messages;
import com.example.WalletProject.models.DTO.DocumentFormatDto;
import com.example.WalletProject.models.Entity.DocumentFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class FullCountryInfoDto {
    @NotBlank(message = Messages.EMPTY_COUNTRY_NAME)
    @Pattern(regexp = "^[а-яА-Я]+$",message = Messages.INVALID_COUNTRY_NAME)
    private String name;
    @NotBlank(message = Messages.EMPTY_PHONE_CODE)
    private String phoneCode;
    @NotNull(message = Messages.EMPTY_DOCUMENT_FORMAT)
    private DocumentFormatDto documentFormat;


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

    public DocumentFormatDto getDocumentFormat() {
        return documentFormat;
    }

    public void setDocumentFormat(DocumentFormatDto documentFormat) {
        this.documentFormat = documentFormat;
    }
}
