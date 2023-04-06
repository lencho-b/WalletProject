package com.example.WalletProject.models.DTO.country;
import com.example.WalletProject.Messages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class FullCountryInfoDto {
    @NotBlank(message = Messages.EMPTY_COUNTRY_NAME)
    @Pattern(regexp = "[a-zа-я]",message = Messages.INVALID_COUNTRY_NAME)
    private String name;
    @NotBlank(message = Messages.EMPTY_PHONE_CODE)
    @Pattern(regexp = "[0-9]",message = Messages.INVALID_PHONE_CODE)
    private String phoneCode;
    @NotBlank(message = Messages.EMPTY_DOCUMENT_FORMAT)
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
