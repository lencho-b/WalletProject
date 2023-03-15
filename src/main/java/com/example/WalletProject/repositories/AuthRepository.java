package com.example.WalletProject.repositories;

import com.example.WalletProject.models.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
//в параметрах репозитория указаны: тип того, что будем искать (Account к примеру), тип, по которому будем искать (к примеру Account Id/AuthId)
@Repository
public interface AuthRepository extends JpaRepository<Auth, BigInteger> {
}
