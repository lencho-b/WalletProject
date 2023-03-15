package com.example.WalletProject.repositories;

import com.example.WalletProject.models.TransactionAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionAccountRepository extends JpaRepository<TransactionAccount, Long> {
}