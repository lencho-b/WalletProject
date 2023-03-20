package com.example.WalletProject.models.DTO;

public class AuthInfoDto{
    private final String login;

    private final String password;

    public AuthInfoDto(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "login = " + login + ", " +
                "password = " + password + ")";
    }
}