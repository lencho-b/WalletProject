package com.example.WalletProject.repositories;

import com.example.WalletProject.models.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query("select t from Account a " +
            "left join TransactionAccount ta on ta.account.id = a.id " +
            "left join Transaction t on ta.transaction.id = t.id " +
            "where a.id=:accountId")
    List<Transaction> findAllByAccountId(Long accountId);
}
