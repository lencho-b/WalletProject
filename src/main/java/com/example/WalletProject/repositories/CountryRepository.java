package com.example.WalletProject.repositories;

import com.example.WalletProject.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//в параметрах репозитория указаны: тип того, что будем искать (Account к примеру), тип, по которому будем искать (к примеру Account Id/AuthId)
@Repository
public interface CountryRepository extends JpaRepository<Country,Integer > {
}
