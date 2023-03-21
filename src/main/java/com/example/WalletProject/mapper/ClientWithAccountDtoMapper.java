package com.example.WalletProject.mapper;

import com.example.WalletProject.dto.ClientWithAccountsDTO;
import com.example.WalletProject.models.Client;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
@Component
public class ClientWithAccountDtoMapper {
    private ModelMapper modelMapper;
    private AccountInfoForAccountsListMapper accountMapper;

    @Autowired
    public ClientWithAccountDtoMapper(AccountInfoForAccountsListMapper accountMapper) {
        this.modelMapper = new ModelMapper();
        modelMapper.createTypeMap(Client.class, ClientWithAccountsDTO.class)
                .addMappings(client -> client.skip(ClientWithAccountsDTO::setAccounts))
                .setPostConverter(toDtoConverter());
        modelMapper.createTypeMap(ClientWithAccountsDTO.class, Client.class)
                .addMappings(client -> client.skip(Client::setAccounts))
                .setPostConverter(toEntityConverter());

        this.accountMapper = accountMapper;
    }

    private Converter<Client, ClientWithAccountsDTO> toDtoConverter() {
        return context -> {
            Client source = context.getSource();
            ClientWithAccountsDTO destination = context.getDestination();
            destination.setAccounts(source.getAccounts()
                    .stream()
                    .map(account -> accountMapper.toDto(account))
                    .collect(Collectors.toList()));
            return context.getDestination();
        };
    }

    private Converter<ClientWithAccountsDTO, Client> toEntityConverter() {
        return context -> {
            ClientWithAccountsDTO source = context.getSource();
            Client destination = context.getDestination();
            destination.setAccounts(source.getAccounts()
                    .stream()
                    .map(account -> accountMapper.toEntity(account))
                    .collect(Collectors.toList()));
            return context.getDestination();
        };
    }

    public ClientWithAccountsDTO toDto(Client entity) {
        return modelMapper.map(entity, ClientWithAccountsDTO.class);
    }

    public Client toEntity(ClientWithAccountsDTO dto) {
        return modelMapper.map(dto, Client.class);
    }
}
