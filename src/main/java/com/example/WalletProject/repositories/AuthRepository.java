package com.example.WalletProject.repositories;

import com.example.WalletProject.models.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<Auth, Long> {
}