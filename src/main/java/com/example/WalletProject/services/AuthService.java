package com.example.WalletProject.services;

import com.example.WalletProject.DTO.AuthInfoDTO;
import com.example.WalletProject.entity.AuthInfo;
import com.example.WalletProject.repositories.AuthInfoRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService
{
    private final AuthInfoRepository authInfoRepository;

    public AuthService(AuthInfoRepository authInfoRepository) {
        this.authInfoRepository = authInfoRepository;
    }
    public AuthInfoDTO getAuthInfoByClientId(Long id)
    {
        AuthInfo authInfo = authInfoRepository.getById(id);
        AuthInfoDTO authInfoDto =
                new AuthInfoDTO
                        (authInfo.getPassword());
        return authInfoDto;
    }
    public void updateAuthClientById(AuthInfoDTO authInfoDto, Long id)
    {
        AuthInfo authInfo = authInfoRepository.getById(id);

        authInfo.setPassword(authInfoDto.getPassword());

        authInfoRepository.save(authInfo);
    }
}
