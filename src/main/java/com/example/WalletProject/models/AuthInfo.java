package com.example.WalletProject.models;
//лучше изменить на client либо user. Назвала как в базе, но нэйминг не понятный

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class AuthInfo {

    @Id
    @Column(name = "client_id")
    private Long id;
//    @OneToOne
//    @MapsId
//    @JoinColumn(name = "client_id")
//    private Account account;
    private String login;
    private String password;

    public AuthInfo() {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthInfo authInfo = (AuthInfo) o;
        // переделать сравнение
        return Objects.equals(id, authInfo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}