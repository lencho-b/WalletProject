package com.example.WalletProject.repositories;

import com.example.WalletProject.models.Entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Integer>
{
    Optional<Currency> getCurrencyByNameLike(String name);
}