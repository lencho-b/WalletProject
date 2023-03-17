package com.example.WalletProject.models.DTO;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link com.example.WalletProject.models.Entity.Client} entity
 */
public class ClientInformationForManageDTO implements Serializable {
    @NotNull
    private final LocalDate createdAt;
    @NotNull
    private final LocalDate updatedAt;
    @NotNull
    private final Boolean frozen;
    @NotNull
    private final Boolean isDelete;
    @NotNull
    private final Boolean isVerify;
    private final Long document_id;

    public ClientInformationForManageDTO(LocalDate createdAt, LocalDate updatedAt, Boolean frozen, Boolean isDelete, Boolean isVerify, Long document_id) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.frozen = frozen;
        this.isDelete = isDelete;
        this.isVerify = isVerify;
        this.document_id = document_id;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public Boolean getFrozen() {
        return frozen;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public Boolean getIsVerify() {
        return isVerify;
    }

    public Long getDocumentId() {
        return document_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientInformationForManageDTO entity = (ClientInformationForManageDTO) o;
        return Objects.equals(this.createdAt, entity.createdAt) &&
                Objects.equals(this.updatedAt, entity.updatedAt) &&
                Objects.equals(this.frozen, entity.frozen) &&
                Objects.equals(this.isDelete, entity.isDelete) &&
                Objects.equals(this.isVerify, entity.isVerify) &&
                Objects.equals(this.document_id, entity.document_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdAt, updatedAt, frozen, isDelete, isVerify, document_id);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "createdAt = " + createdAt + ", " +
                "updatedAt = " + updatedAt + ", " +
                "frozen = " + frozen + ", " +
                "isDelete = " + isDelete + ", " +
                "isVerify = " + isVerify + ", " +
                "document = " + document_id + ")";
    }
}