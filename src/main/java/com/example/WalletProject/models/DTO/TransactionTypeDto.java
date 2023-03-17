package com.example.WalletProject.models.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.example.WalletProject.models.Entity.TransactionType} entity
 */
public class TransactionTypeDto implements Serializable {
    private final Integer id;
    @Size(max = 50)
    @NotNull
    private final String type;
    @Size(max = 100)
    @NotNull
    private final String comment;

    public TransactionTypeDto(Integer id, String type, String comment) {
        this.id = id;
        this.type = type;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionTypeDto entity = (TransactionTypeDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.type, entity.type) &&
                Objects.equals(this.comment, entity.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, comment);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "type = " + type + ", " +
                "comment = " + comment + ")";
    }
}