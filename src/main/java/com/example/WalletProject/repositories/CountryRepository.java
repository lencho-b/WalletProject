package com.example.WalletProject.repositories;

import com.example.WalletProject.models.Entity.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
    Page<Country> findAll(Pageable pageable);

    Optional<Country> findByName(String name);
}