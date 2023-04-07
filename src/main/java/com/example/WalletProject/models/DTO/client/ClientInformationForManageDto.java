package com.example.WalletProject.models.DTO.client;

public class ClientInformationForManageDto {
    private Boolean frozen;
    private Boolean isVerify;

    public Boolean getFrozen() {
        return frozen;
    }

    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
    }

    public Boolean getVerify() {
        return isVerify;
    }

    public void setVerify(Boolean verify) {
        isVerify = verify;
    }

    @Override
    public String toString() {
        return "ClientInformationForManageDTO{" +
                "frozen=" + frozen +
                ", isVerify=" + isVerify +
                '}';
    }
}