package com.example.WalletProject.models.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 50)
    @NotNull
    @Column(name = "firstname", nullable = false, length = 50)
    private String firstname;

    @Size(max = 50)
    @NotNull
    @Column(name = "lastname", nullable = false, length = 50)
    private String lastname;

    @Size(max = 50)
    @NotNull
    @Column(name = "patronymic", nullable = false, length = 50)
    private String patronymic;

    @NotNull
    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @NotNull
    @Column(name = "email", nullable = false, length = Integer.MAX_VALUE)
    private String email;

    @Size(max = 50)
    @NotNull
    @Column(name = "phone_number", nullable = false, length = 50)
    private String phoneNumber;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;


    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @NotNull
    @Column(name = "frozen", nullable = false)
    private Boolean frozen = false;

    @NotNull
    @Column(name = "is_delete", nullable = false)
    private Boolean isDelete = false;

    @NotNull
    @Column(name = "is_verify", nullable = false)
    private Boolean isVerify = false;

    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
    private List<Account>accounts;

    public Client(String firstname, String lastname, String patronymic, LocalDate dateOfBirth, String email, String phoneNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Client(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    public Boolean getVerify() {
        return isVerify;
    }

    public void setVerify(Boolean verify) {
        isVerify = verify;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Client(Long id, String firstname, String lastname, String patronymic, LocalDate dateOfBirth, String email, String phoneNumber, LocalDate createdAt, LocalDate updatedAt, Boolean frozen, Boolean isDelete, Boolean isVerify, Document document) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.frozen = frozen;
        this.isDelete = isDelete;
        this.isVerify = isVerify;
    }
    public Client() {
    }
    public Client(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getFrozen() {
        return frozen;
    }

    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Boolean getIsVerify() {
        return isVerify;
    }

    public void setIsVerify(Boolean isVerify) {
        this.isVerify = isVerify;
    }

}