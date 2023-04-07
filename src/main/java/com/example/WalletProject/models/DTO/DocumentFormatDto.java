package com.example.WalletProject.models.DTO;

import com.example.WalletProject.Messages;
import jakarta.validation.constraints.NotBlank;

public class DocumentFormatDto {
    private String format;

    @NotBlank(message = Messages.EMPTY_DOCUMENT_FORMAT)
    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
