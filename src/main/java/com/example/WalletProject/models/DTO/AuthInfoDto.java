package com.example.WalletProject.models.DTO;

public class AuthInfoDto{

    private final String password;

    public AuthInfoDto( String password) {
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