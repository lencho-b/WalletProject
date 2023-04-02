package com.example.WalletProject.repositories;

import com.example.WalletProject.models.Entity.TransactionAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionAccountRepository extends JpaRepository<TransactionAccount, Long> {
    Optional<TransactionAccount> findByTransactionIdAndAccountId(Long transactionId, Long accountId);

}
