package com.example.WalletProject.repositories;

import com.example.WalletProject.models.Entity.AuthInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthInfoRepository extends JpaRepository<AuthInfo, Long> {
}