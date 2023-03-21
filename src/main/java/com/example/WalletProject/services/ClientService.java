package com.example.WalletProject.services;

import com.example.WalletProject.models.DTO.ClientDto;
import com.example.WalletProject.models.DTO.ClientInformationForMainPageDTO;
import com.example.WalletProject.models.DTO.ClientInformationForManageDTO;
import com.example.WalletProject.models.DTO.RegistrationDto;
import com.example.WalletProject.models.Entity.AuthInfo;
import com.example.WalletProject.models.Entity.Client;
import com.example.WalletProject.models.Entity.Role;
import com.example.WalletProject.repositories.AuthInfoRepository;
import com.example.WalletProject.repositories.ClientRepository;
import com.example.WalletProject.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService
{
    private final ClientRepository clientRepository;
    private final AuthInfoRepository authInfoRepository;
    private final RoleRepository roleRepository;

    public ClientService(ClientRepository clientRepository, AuthInfoRepository authInfoRepository, RoleRepository roleRepository) {
        this.clientRepository = clientRepository;
        this.authInfoRepository = authInfoRepository;
        this.roleRepository = roleRepository;
    }
    public List<ClientDto> getAllClients()
    {
        List<ClientDto>allClientsDto = new ArrayList<>();
        List<Client>allClients = clientRepository.findAll();
        for (Client client:allClients)
        {
            allClientsDto.add(new ClientDto(
                    client.getFirstname(),
                    client.getLastname(),
                    client.getPatronymic(),
                    client.getDateOfBirth(),
                    client.getEmail(),
                    client.getPhoneNumber(),
                    client.getCreatedAt(),
                    client.getUpdatedAt(),
                    client.getFrozen(),
                    client.getIsDelete(),
                    client.getIsVerify()));
        }
        return allClientsDto;
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
    public ClientDto getClientByIdForAdmin(Long id)
    {
        Client client = clientRepository.findById(id).get();
        ClientDto clientDto = new ClientDto
                        (
                        client.getFirstname(),
                        client.getLastname(),
                        client.getPatronymic(),
                        client.getDateOfBirth(),
                        client.getEmail(),
                        client.getPhoneNumber(),
                        client.getCreatedAt(),
                        client.getUpdatedAt(),
                        client.getFrozen(),
                        client.getIsDelete(),
                        client.getIsVerify());
        return clientDto;
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

    public void updateInformationForManageByClientId(Long id,ClientInformationForManageDTO clientInformationForManageDTO)
    {
        Client client = clientRepository.getById(id);
        client.setFrozen(clientInformationForManageDTO.getFrozen());
        client.setIsVerify(clientInformationForManageDTO.getIsVerify());
    }

    public void deleteClientById(Long id)
    {
        clientRepository.deleteById(id);
    }
}