package com.example.WalletProject.repositories;

import com.example.WalletProject.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}