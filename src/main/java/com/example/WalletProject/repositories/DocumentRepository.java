package com.example.WalletProject.repositories;

import com.example.WalletProject.models.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Integer> {
}