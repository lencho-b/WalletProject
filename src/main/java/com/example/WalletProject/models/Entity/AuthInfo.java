package com.example.WalletProject.models.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "auth_info")
public class AuthInfo {
    @Id
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @Column(name = "client_id", nullable = false)
    private Long id;


    @Column(name = "password", nullable = false, length = Integer.MAX_VALUE)
    private String password;

    public AuthInfo() {
    }

    public AuthInfo(Long id, String password) {
        this.id = id;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                ", password='" + password + '\'' +
                '}';
    }
}