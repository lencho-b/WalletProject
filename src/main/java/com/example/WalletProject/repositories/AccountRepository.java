package com.example.WalletProject.repositories;

import com.example.WalletProject.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

//в параметрах репозитория указаны: тип того, что будем искать (Account), тип, по которому будем искать (Account Id/AuthId)
@Repository
public interface AccountRepository extends JpaRepository<Account, Long>  {
    Set<Account> findByClientId(Long clientId);
}
