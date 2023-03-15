package com.example.WalletProject.repositories;

import com.example.WalletProject.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}