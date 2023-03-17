package com.example.WalletProject.models.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "role_name", nullable = false, length = 50)
    private String roleName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}