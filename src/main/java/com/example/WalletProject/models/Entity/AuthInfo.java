package com.example.WalletProject.models.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "auth_info")
public class AuthInfo {
    @Id
    @Column(name = "client_id", nullable = false)
    private Long id;

    @Column(name = "login", nullable = false, length = 50)
    private String login;

    @Column(name = "password", nullable = false, length = Integer.MAX_VALUE)
    private String password;

    public AuthInfo() {
    }

    public AuthInfo(Long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AuthInfo{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}