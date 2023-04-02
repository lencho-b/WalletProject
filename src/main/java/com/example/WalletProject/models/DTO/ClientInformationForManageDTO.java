package com.example.WalletProject.models.DTO;

public class ClientInformationForManageDTO {
    private final Boolean frozen;

    private final Boolean isVerify;

    public ClientInformationForManageDTO(Boolean frozen, Boolean isVerify) {
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
    public String toString() {
        return "ClientInformationForManageDTO{" +
                "frozen=" + frozen +
                ", isVerify=" + isVerify +
                '}';
    }
}