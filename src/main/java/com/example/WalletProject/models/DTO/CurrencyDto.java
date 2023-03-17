package com.example.WalletProject.models.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.example.WalletProject.models.Entity.Currency} entity
 */
public class CurrencyDto implements Serializable {
    private final Integer id;
    @Size(max = 50)
    @NotNull
    private final String name;
    private final Integer index;

    public CurrencyDto(Integer id, String name, Integer index) {
        this.id = id;
        this.name = name;
        this.index = index;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getIndex() {
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyDto entity = (CurrencyDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.index, entity.index);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, index);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "index = " + index + ")";
    }
}