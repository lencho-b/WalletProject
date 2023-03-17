package com.example.WalletProject.models.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "currency")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "index")
    private Integer index;

    public Currency() {
    }

    public Currency(Integer id, String name, Integer index) {
        this.id = id;
        this.name = name;
        this.index = index;
    }

    public Currency(Integer id) {
        this.id = id;
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

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

}