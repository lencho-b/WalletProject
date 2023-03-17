package com.example.WalletProject.models.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.example.WalletProject.models.Entity.Country} entity
 */
public class CountryDto implements Serializable {
    private final Integer id;
    @Size(max = 50)
    @NotNull
    private final String name;
    @Size(max = 50)
    @NotNull
    private final String phoneCode;
    @NotNull
    private final DocumentFormatDto documentFormat;

    public CountryDto(Integer id, String name, String phoneCode, DocumentFormatDto documentFormat) {
        this.id = id;
        this.name = name;
        this.phoneCode = phoneCode;
        this.documentFormat = documentFormat;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public DocumentFormatDto getDocumentFormat() {
        return documentFormat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryDto entity = (CountryDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.phoneCode, entity.phoneCode) &&
                Objects.equals(this.documentFormat, entity.documentFormat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phoneCode, documentFormat);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "phoneCode = " + phoneCode + ", " +
                "documentFormat = " + documentFormat + ")";
    }
}