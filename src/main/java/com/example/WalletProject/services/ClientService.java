package com.example.WalletProject.services;

import com.example.WalletProject.models.DTO.*;
import com.example.WalletProject.models.Entity.AuthInfo;
import com.example.WalletProject.models.Entity.Client;
import com.example.WalletProject.models.Entity.Document;
import com.example.WalletProject.models.Entity.Role;
import com.example.WalletProject.repositories.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ClientService
{
    private final ClientRepository clientRepository;
    private final AuthInfoRepository authInfoRepository;
    private final DocumentRepository documentRepository;
    private final CountryRepository countryRepository;
    private final RoleRepository roleRepository;

    public ClientService(ClientRepository clientRepository, AuthInfoRepository authInfoRepository, DocumentRepository documentRepository, CountryRepository countryRepository, RoleRepository roleRepository) {
        this.clientRepository = clientRepository;
        this.authInfoRepository = authInfoRepository;
        this.documentRepository = documentRepository;
        this.countryRepository = countryRepository;
        this.roleRepository = roleRepository;
    }

    public ClientInformationForMainPageDTO  getClientById(Long id)
    {
        Client client = clientRepository.findById(id).get();
        ClientInformationForMainPageDTO  clientInformationForMainPageDTO = new ClientInformationForMainPageDTO
                (client.getFirstname()
                ,client.getLastname()
                ,client.getPatronymic()
                ,client.getDateOfBirth()
                ,client.getEmail()
                ,client.getPhoneNumber());
        return clientInformationForMainPageDTO ;
    }
    public AuthInfoDto getAuthInfoByClientId(Long id)
    {
        AuthInfo authInfo = authInfoRepository.getById(id);
        AuthInfoDto authInfoDto =
                new AuthInfoDto
                        (authInfo.getLogin(),
                         authInfo.getPassword());
        return authInfoDto;
    }
    public void updateAuthClientById(AuthInfoDto authInfoDto,Long id)
    {
        AuthInfo authInfo = authInfoRepository.getById(id);

        authInfo.setLogin(authInfoDto.getLogin());
        authInfo.setPassword(authInfoDto.getPassword());

        authInfoRepository.save(authInfo);
    }


    public DocumentResponseDto getDocumentByClientId(Long id)
    {
        Document document = documentRepository.getById(id);
        DocumentResponseDto documentResponseDto =
                new DocumentResponseDto
                (document.getDocumentNumber(),
                 document.getIssueDate(),
                 document.getCountry().getId());
        return documentResponseDto;
    }

    public ClientInformationForManageDTO getClientInformationForManageByClientId(Long id)
    {
        Client client = clientRepository.getById(id);
        ClientInformationForManageDTO clientInformationForManageDTO =
                new ClientInformationForManageDTO
                (
                        client.getFrozen(),
                        client.getIsVerify()
                );
        return clientInformationForManageDTO;

    }
    public void createDocumentByClientId(Long id, DocumentRequestDto documentRequestDto)
    {
        Document document = new Document();
        document.setClient_id(id);
        document.setDocumentNumber(documentRequestDto.getDocumentNumber());
        document.setIssueDate(documentRequestDto.getIssueDate());
        document.setCreatedAt(LocalDate.now());
        document.setCountry(countryRepository.getById(documentRequestDto.getCountryId()));
        documentRepository.save(document);
    }

    public void deleteClientsDocumentByClientId(Long id)
    {
        Document document = documentRepository.getById(id);
        documentRepository.delete(document);
    }

    public void createNewClient(RegistrationDto registrationDto)
    {
        Role role = new Role();
     Client client = new Client
             (
                     registrationDto.getFirstname(),
                     registrationDto.getLastname(),
                     registrationDto.getPatronymic(),
                     registrationDto.getDateOfBirth(),
                     registrationDto.getEmail(),
                     registrationDto.getPhoneNumber(),
                     LocalDate.now(),
                     null,
                     false,
                     false,
                     false
             );
        client.setRole(roleRepository.getById(registrationDto.getRole()));
     clientRepository.save(client);
        AuthInfo authInfo = new AuthInfo(
                client.getId(),
                registrationDto.getLogin(),
                registrationDto.getPassword()
        );
     authInfoRepository.save(authInfo);
     client.setRole(roleRepository.getById(registrationDto.getRole()));
     role.setClient(clientRepository.getById(client.getId()));
    }

    public void updateInformationByClientId(Long id, ClientInformationForMainPageDTO clientInformationForMainPageDTO)
    {
        Client client = clientRepository.getById(id);
        client.setFirstname(clientInformationForMainPageDTO.getFirstname());
        client.setLastname(clientInformationForMainPageDTO.getLastname());
        client.setPatronymic(clientInformationForMainPageDTO.getPatronymic());
        client.setDateOfBirth(clientInformationForMainPageDTO.getDateOfBirth());
        client.setEmail(clientInformationForMainPageDTO.getEmail());
        client.setPhoneNumber(clientInformationForMainPageDTO.getPhoneNumber());
        client.setUpdatedAt(LocalDate.now());
        clientRepository.save(client);
    }
}