package com.example.WalletProject.models.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "currency")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(name = "id_from_api")
    private Integer idFromApi;

    public Currency(Integer id, String name, Integer idFromApi) {
        this.id = id;
        this.name = name;
        this.idFromApi = idFromApi;
    }

    public Currency() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdFromApi() {
        return idFromApi;
    }

    public void setIdFromApi(Integer idFromApi) {
        this.idFromApi = idFromApi;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idFromApi=" + idFromApi +
                '}';
    }
}