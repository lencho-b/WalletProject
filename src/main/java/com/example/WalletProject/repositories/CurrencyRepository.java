package com.example.WalletProject.repositories;

import com.example.WalletProject.models.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
}