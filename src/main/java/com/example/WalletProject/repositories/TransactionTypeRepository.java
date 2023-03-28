package com.example.WalletProject.repositories;

import com.example.WalletProject.models.Entity.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionTypeRepository extends JpaRepository<TransactionType, Integer> {
    Optional<TransactionType> findTransactionTypeByType(String typeName);
}
