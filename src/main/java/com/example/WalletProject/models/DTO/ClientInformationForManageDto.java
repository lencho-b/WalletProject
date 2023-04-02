package com.example.WalletProject.models.DTO;

public class ClientInformationForManageDto {
    private Boolean frozen;

    private Boolean isVerify;
    public ClientInformationForManageDto(Boolean frozen, Boolean isVerify) {
        this.frozen = frozen;
        this.isVerify = isVerify;
    }

    public ClientInformationForManageDto() {
    }

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