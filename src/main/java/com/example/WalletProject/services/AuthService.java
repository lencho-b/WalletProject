package com.example.WalletProject.services;

import com.example.WalletProject.models.Entity.AuthInfo;
import com.example.WalletProject.repositories.AuthInfoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final AuthInfoRepository authInfoRepository;

    public AuthService(AuthInfoRepository authInfoRepository) {
        this.authInfoRepository = authInfoRepository;
    }


    public void updateAuthClientById(String password, Long id) {
        AuthInfo authInfo = authInfoRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        authInfo.setPassword(password);
        authInfoRepository.save(authInfo);
    }
}