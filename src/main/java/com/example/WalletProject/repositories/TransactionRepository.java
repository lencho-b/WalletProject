package com.example.WalletProject.repositories;

import com.example.WalletProject.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}