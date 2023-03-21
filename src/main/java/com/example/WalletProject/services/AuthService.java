package com.example.WalletProject.services;

import com.example.WalletProject.models.DTO.AuthInfoDto;
import com.example.WalletProject.models.Entity.AuthInfo;
import com.example.WalletProject.repositories.AuthInfoRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService
{
    private final AuthInfoRepository authInfoRepository;

    public AuthService(AuthInfoRepository authInfoRepository) {
        this.authInfoRepository = authInfoRepository;
    }
    public AuthInfoDto getAuthInfoByClientId(Long id)
    {
        AuthInfo authInfo = authInfoRepository.getById(id);
        AuthInfoDto authInfoDto =
                new AuthInfoDto
                        (authInfo.getPassword());
        return authInfoDto;
    }
    public void updateAuthClientById(AuthInfoDto authInfoDto,Long id)
    {
        AuthInfo authInfo = authInfoRepository.getById(id);

        authInfo.setPassword(authInfoDto.getPassword());

        authInfoRepository.save(authInfo);
    }
}
