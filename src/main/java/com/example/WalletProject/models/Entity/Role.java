package com.example.WalletProject.models.Entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
public class Role implements GrantedAuthority {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String roleName;
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "client_role",joinColumns = @JoinColumn (name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id"))
    private List<Client> clients;

    public Role(Integer id, String roleName, List<Client> clients) {
        this.id = id;
        this.roleName = roleName;
        this.clients = clients;
    }

    public Role() {
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClient(Client client) {
        if(clients == null)
        {
            clients = new ArrayList<>();
        }
        clients.add(client);
    }

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

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", clients=" + clients +
                '}';
    }

    @Override
    public String getAuthority() {
        return getRoleName();
    }

}