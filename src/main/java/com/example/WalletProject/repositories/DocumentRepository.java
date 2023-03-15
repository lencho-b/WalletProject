package com.example.WalletProject.repositories;

import com.example.WalletProject.models.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
@Repository
public interface DocumentRepository extends JpaRepository<Document, BigInteger> {
}
