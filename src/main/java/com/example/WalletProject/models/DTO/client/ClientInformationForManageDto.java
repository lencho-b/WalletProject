package com.example.WalletProject.models.DTO.client;

public class ClientInformationForManageDto {
    private Boolean frozen;
    private Boolean isVerify;

    public Boolean getFrozen() {
        return frozen;
    }

    public void setFrozen() {
        this.frozen = true;
    }

    public Boolean getVerify() {
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