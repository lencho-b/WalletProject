package com.example.WalletProject.services;

import com.example.WalletProject.exceptions.ClientNotFoundException;
import com.example.WalletProject.exceptions.UserNotFoundException;
import com.example.WalletProject.models.DTO.client.ClientDto;
import com.example.WalletProject.models.DTO.client.ClientInformationForMainPageDto;
import com.example.WalletProject.models.DTO.client.ClientInformationForManageDto;
import com.example.WalletProject.models.DTO.client.RegistrationDto;
import com.example.WalletProject.models.Entity.AuthInfo;
import com.example.WalletProject.models.Entity.Client;
import com.example.WalletProject.repositories.AuthInfoRepository;
import com.example.WalletProject.repositories.ClientRepository;
import com.example.WalletProject.repositories.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.stream.Collectors;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final AuthInfoRepository authInfoRepository;
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    public ClientService(ClientRepository clientRepository, AuthInfoRepository authInfoRepository, RoleRepository roleRepository, ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
        this.authInfoRepository = authInfoRepository;
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }


    public Page<ClientDto> getAllClients(Pageable pageable) {
        Page<Client> allClients = clientRepository.findAll(pageable);
        if (allClients.isEmpty()) {
            throw new ClientNotFoundException("page of clients is empty");
        }
        return new PageImpl<>(allClients.getContent().stream()
                .map(client -> modelMapper.map(client, ClientDto.class))
                .collect(Collectors.toList()));
    }


    public ClientInformationForMainPageDto getClientById(Long id) {
        Client client = finedOrThrow(id);
        return modelMapper.map(client, ClientInformationForMainPageDto.class);

    }

    //не понятен смыс метода
    public ClientDto getClientByIdForAdmin(Long id) {
        return clientRepository.findById(id)
                .map(client -> modelMapper.map(client, ClientDto.class)
                )
                .orElseThrow(() -> new ClientNotFoundException("Client with id " + id + " not found"));
    }

    public ClientInformationForManageDto getClientInformationForManageByClientId(Long id) {
        Client client = finedOrThrow(id);
        return modelMapper.map(client, ClientInformationForManageDto.class);
    }

    public void createNewClient(RegistrationDto registrationDto) {
        Client client = modelMapper.map(registrationDto, Client.class);
        // set role сразу юзера и всегда юзера
        client.setRole(roleRepository.findById(Roles.USER.id)
                .orElseThrow(() -> new UserNotFoundException("User " + Roles.USER.id + " not found")));
        client.setCreatedAt(LocalDate.now());
        clientRepository.save(client);
        AuthInfo authInfo = new AuthInfo(
                client.getId(),
                registrationDto.getPassword()
        );
        authInfoRepository.save(authInfo);
    }


    public void updateInformationByClientId(Long id, ClientInformationForMainPageDto clientInformationForMainPageDTO) {
        Client clientToBeUpdated = finedOrThrow(id);
        Client client = modelMapper.map(clientInformationForMainPageDTO, Client.class);
        client.setId(clientToBeUpdated.getId());
        client.setCreatedAt(clientToBeUpdated.getCreatedAt());
        client.setUpdatedAt(LocalDate.now());
        client.setFrozen(clientToBeUpdated.getFrozen());
        client.setIsVerify(clientToBeUpdated.getIsVerify());
        client.setDelete(clientToBeUpdated.getIsDelete());
        clientRepository.save(client);
    }

    public void updateInformationForManageByClientId(Long id, ClientInformationForManageDto clientInformationForManageDTO) {
        Client client = finedOrThrow(id);
        client.setFrozen(clientInformationForManageDTO.getFrozen());
        client.setIsVerify(clientInformationForManageDTO.getVerify());
        clientRepository.save(client);
    }

    public void deleteClientById(Long id) {
        Client client = finedOrThrow(id);
        client.setDelete(true);
        clientRepository.save(client);
    }

    private Client finedOrThrow(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException("Client with id " + id + " not found"));
        if (client.getIsDelete().equals(true)) {
            throw new SecurityException("Client removed");
        }
        return client;
    }

    private enum Roles {
        USER(1), ADMIN(2);
        private final Integer id;

        Roles(Integer id) {
            this.id = id;
        }

    }
}