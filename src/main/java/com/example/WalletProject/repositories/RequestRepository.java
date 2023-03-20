package com.example.WalletProject.repositories;

import com.example.WalletProject.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
@Repository
public interface RequestRepository extends JpaRepository<Role, BigInteger> {
}
