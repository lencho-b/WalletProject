package com.example.WalletProject.DTO;

public class AuthInfoDTO {

    private final String password;

    public AuthInfoDTO(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "password = " + password + ")";
    }
}