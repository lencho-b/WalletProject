package com.example.WalletProject.repositories;

import com.example.WalletProject.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

//в параметрах репозитория указаны: тип того, что будем искать (Account), тип, по которому будем искать (Account Id/AuthId)
@Repository
public interface AccountRepository extends JpaRepository<Account, BigInteger>  {

    List<Account> findByClientId(BigInteger clientId);
}
