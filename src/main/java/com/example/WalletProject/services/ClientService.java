package com.example.WalletProject.services;

import com.example.WalletProject.models.DTO.ClientDto;
import com.example.WalletProject.models.DTO.ClientInformationForMainPageDTO;
import com.example.WalletProject.models.DTO.ClientInformationForManageDTO;
import com.example.WalletProject.models.DTO.RegistrationDto;
import com.example.WalletProject.models.Entity.AuthInfo;
import com.example.WalletProject.models.Entity.Client;
import com.example.WalletProject.repositories.AuthInfoRepository;
import com.example.WalletProject.repositories.ClientRepository;
import com.example.WalletProject.repositories.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final AuthInfoRepository authInfoRepository;
    private final RoleRepository roleRepository;

    public ClientService(ClientRepository clientRepository, AuthInfoRepository authInfoRepository, RoleRepository roleRepository) {
        this.clientRepository = clientRepository;
        this.authInfoRepository = authInfoRepository;
        this.roleRepository = roleRepository;
    }


    public List<ClientDto> getAllClients(Integer numberPage) {
        Page<Client> allClients = clientRepository.findAll(PageRequest.of(numberPage, 20));
        return allClients.stream()
                .map(client -> new ClientDto(
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
                        client.getIsVerify()))
                .collect(Collectors.toList());
    }


    public ClientInformationForMainPageDTO getClientById(Long id) {
        Client client = finedOrThrow(id);
        return new ClientInformationForMainPageDTO(
                client.getFirstname(),
                client.getLastname(),
                client.getPatronymic(),
                client.getDateOfBirth(),
                client.getEmail(),
                client.getPhoneNumber());
    }

    //не понятен смыс метода
    public ClientDto getClientByIdForAdmin(Long id) {
        return clientRepository.findById(id)
                .map(client -> new ClientDto(
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
                        client.getIsVerify()
                ))
                .orElseThrow(() -> new EntityNotFoundException("Client not found"));
    }

    public ClientInformationForManageDTO getClientInformationForManageByClientId(Long id) {
        Client client = finedOrThrow(id);
        return new ClientInformationForManageDTO(client.getFrozen(), client.getIsVerify());
    }

    public void createNewClient(RegistrationDto registrationDto) {
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
        // set role сразу юзера и всегда юзера
        client.setRole(roleRepository.findById(Roles.USER.id)
                .orElseThrow(() -> new EntityNotFoundException("Role not found")));
        clientRepository.save(client);
        AuthInfo authInfo = new AuthInfo(
                client.getId(),
                registrationDto.getPassword()
        );
        authInfoRepository.save(authInfo);
    }

    //перезанирание информации о клиенте в entity из-за пустых полей dto
    public void updateInformationByClientId(Long id, ClientInformationForMainPageDTO clientInformationForMainPageDTO) {
        Client client = finedOrThrow(id);
        client.setFirstname(clientInformationForMainPageDTO.getFirstname());
        client.setLastname(clientInformationForMainPageDTO.getLastname());
        client.setPatronymic(clientInformationForMainPageDTO.getPatronymic());
        client.setDateOfBirth(clientInformationForMainPageDTO.getDateOfBirth());
        client.setEmail(clientInformationForMainPageDTO.getEmail());
        client.setPhoneNumber(clientInformationForMainPageDTO.getPhoneNumber());
        client.setUpdatedAt(LocalDate.now());
        clientRepository.save(client);
    }

    public void updateInformationForManageByClientId(Long id, ClientInformationForManageDTO clientInformationForManageDTO) {
        Client client = finedOrThrow(id);
        client.setFrozen(clientInformationForManageDTO.getFrozen());
        client.setIsVerify(clientInformationForManageDTO.getIsVerify());
    }

    public void deleteClientById(Long id) {
        Client client = finedOrThrow(id);
        client.setDelete(true);
        clientRepository.save(client);
    }

    private Client finedOrThrow(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client not found"));
        if(client.getIsDelete().equals(true)) {
            throw new SecurityException("Client removed");
        }
        return client;
    }

    private enum Roles {
        USER(1), ADMIN(2);
        private Integer id;
        Roles(Integer id) {
            this.id = id;
        }

    }
}