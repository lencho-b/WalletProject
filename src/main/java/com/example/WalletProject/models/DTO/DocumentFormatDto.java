package com.example.WalletProject.models.DTO;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.example.WalletProject.models.Entity.DocumentFormat} entity
 */
public class DocumentFormatDto implements Serializable {
    private final Integer id;
    private final String documentFormat;

    public DocumentFormatDto(Integer id, String documentFormat) {
        this.id = id;
        this.documentFormat = documentFormat;
    }

    public Integer getId() {
        return id;
    }

    public String getDocumentFormat() {
        return documentFormat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentFormatDto entity = (DocumentFormatDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.documentFormat, entity.documentFormat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, documentFormat);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "documentFormat = " + documentFormat + ")";
    }
}