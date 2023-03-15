package com.example.WalletProject.repositories;

import com.example.WalletProject.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}