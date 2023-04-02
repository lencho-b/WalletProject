package com.example.WalletProject.repositories;

import com.example.WalletProject.models.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findAccountsByClientId(Long id);

    @Query("SELECT a FROM Account a WHERE a.id=:idAcc AND a.client.id=:idCl")
    Optional<Account> findAccountByIdAndByClientId(@Param("idAcc") Long idAcc, @Param("idCl") Long idCl);
}