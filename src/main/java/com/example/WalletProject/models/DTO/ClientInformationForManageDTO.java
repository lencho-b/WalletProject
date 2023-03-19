package com.example.WalletProject.models.DTO;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.example.WalletProject.models.Entity.Client} entity
 */
public class ClientInformationForManageDTO implements Serializable {

    @NotNull
    private final Boolean frozen;
    @NotNull
    private final Boolean isVerify;
    public ClientInformationForManageDTO( Boolean frozen,Boolean isVerify) {
        this.frozen = frozen;
        this.isVerify = isVerify;
    }


    public Boolean getFrozen() {
        return frozen;
    }

    public Boolean getIsVerify() {
        return isVerify;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientInformationForManageDTO entity = (ClientInformationForManageDTO) o;
        return
                Objects.equals(this.frozen, entity.frozen) &&
                Objects.equals(this.isVerify, entity.isVerify);
    }

    @Override
    public int hashCode() {
        return Objects.hash( frozen,isVerify);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "frozen = " + frozen + ", " +
                "isVerify = " + isVerify + ")";
    }
}