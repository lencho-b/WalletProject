package com.example.WalletProject.models.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.example.WalletProject.models.Entity.Role} entity
 */
public class RoleDto implements Serializable {
    private final Integer id;
    @Size(max = 50)
    @NotNull
    private final String roleName;

    public RoleDto(Integer id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public Integer getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleDto entity = (RoleDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.roleName, entity.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleName);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "roleName = " + roleName + ")";
    }
}