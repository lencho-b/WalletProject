package com.example.WalletProject.mapper;

import com.example.WalletProject.dto.ClientDTO;

import com.example.WalletProject.models.Client;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientDtoMapper {
    private ModelMapper modelMapper;
    private DocumentMapper documentMapper;

    @Autowired
    public ClientDtoMapper(DocumentMapper documentMapper) {
        this.modelMapper = new ModelMapper();
        modelMapper.createTypeMap(Client.class, ClientDTO.class)
                .addMappings(client -> client.skip(ClientDTO::setDocument))
                .setPostConverter(toDtoConverter());
        modelMapper.createTypeMap(ClientDTO.class, Client.class)
                .addMappings(client -> client.skip(Client::setAccounts))
                .setPostConverter(toEntityConverter());

        this.documentMapper = documentMapper;
    }

    private Converter<Client, ClientDTO> toDtoConverter() {
        return context -> {
            Client source = context.getSource();
            ClientDTO destination = context.getDestination();
            destination.setDocument(documentMapper.toDto(source.getDocument()));
            return context.getDestination();
        };
    }

    private Converter<ClientDTO, Client> toEntityConverter() {
        return context -> {
            ClientDTO source = context.getSource();
            Client destination = context.getDestination();
            destination.setDocument(documentMapper.toEntity(source.getDocument()));
            return context.getDestination();
        };
    }

    public ClientDTO toDto(Client entity) {
        return modelMapper.map(entity, ClientDTO.class);
    }

    public Client toEntity(ClientDTO dto) {
        return modelMapper.map(dto, Client.class);
    }
}
