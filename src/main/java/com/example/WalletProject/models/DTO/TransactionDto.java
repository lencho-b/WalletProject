package com.example.WalletProject.models.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link com.example.WalletProject.models.Entity.Transaction} entity
 */
public class TransactionDto implements Serializable {
    private Long id;
    @NotNull
    private Long value;
    @Size(max = 100)
    @NotNull
    private String message;
    @NotNull
    private Instant startDateTime;
    private Instant finishDateTime;
    @NotNull
    private Boolean status;
    @NotNull
    private Integer type;


    public TransactionDto(Long id, Long value, String message, Instant startDateTime, Instant finishDateTime, Boolean status, Integer type) {
        this.id = id;
        this.value = value;
        this.message = message;
        this.startDateTime = startDateTime;
        this.finishDateTime = finishDateTime;
        this.status = status;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public Long getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }

    public Instant getStartDateTime() {
        return startDateTime;
    }

    public Instant getFinishDateTime() {
        return finishDateTime;
    }

    public Boolean getStatus() {
        return status;
    }

    public Integer getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionDto entity = (TransactionDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.value, entity.value) &&
                Objects.equals(this.message, entity.message) &&
                Objects.equals(this.startDateTime, entity.startDateTime) &&
                Objects.equals(this.finishDateTime, entity.finishDateTime) &&
                Objects.equals(this.status, entity.status) &&
                Objects.equals(this.type, entity.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, message, startDateTime, finishDateTime, status, type);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "value = " + value + ", " +
                "message = " + message + ", " +
                "startDateTime = " + startDateTime + ", " +
                "finishDateTime = " + finishDateTime + ", " +
                "status = " + status + ", " +
                "type = " + type + ")";
    }
}