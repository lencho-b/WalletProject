package com.example.WalletProject.repositories;

import com.example.WalletProject.models.Entity.DocumentFormat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DocumentFormatRepository extends JpaRepository<DocumentFormat, Integer> {
    Optional<DocumentFormat>findByDocumentFormat(String format);
}