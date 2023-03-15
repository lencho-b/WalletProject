package com.example.WalletProject.repositories;

import com.example.WalletProject.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByClientId(BigInteger clientId);


}