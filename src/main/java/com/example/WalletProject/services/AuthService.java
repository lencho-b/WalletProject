package com.example.WalletProject.services;

import com.example.WalletProject.models.DTO.AuthInfoDTO;
import com.example.WalletProject.models.Entity.AuthInfo;
import com.example.WalletProject.repositories.AuthInfoRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final AuthInfoRepository authInfoRepository;

    public AuthService(AuthInfoRepository authInfoRepository) {
        this.authInfoRepository = authInfoRepository;
    }


    public void updateAuthClientById(AuthInfoDTO authInfoDto, Long id) {
        AuthInfo authInfo = authInfoRepository.getById(id);
        authInfo.setPassword(authInfoDto.getPassword());
        authInfoRepository.save(authInfo);
    }
}