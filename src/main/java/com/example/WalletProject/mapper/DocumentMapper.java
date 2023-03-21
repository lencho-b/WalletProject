package com.example.WalletProject.mapper;


import com.example.WalletProject.dto.DocumentDTO;

import com.example.WalletProject.models.Document;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DocumentMapper {

    private final ModelMapper modelMapper;

    public DocumentMapper(){
        this.modelMapper = new ModelMapper();

        modelMapper.createTypeMap(Document.class, DocumentDTO.class)
                .addMappings(account-> account.skip(DocumentDTO::setCountry)).setPostConverter(toDtoConverter());

    }
    private Converter<Document, DocumentDTO> toDtoConverter(){
        return context -> {
            Document source = context.getSource();
            DocumentDTO destination = context.getDestination();
            destination.setCountry(source.getCountry().getName());
            return context.getDestination();
        };
    }

    // должен быть еще ковертер в сущность, но пока не решили как будем сетить страну.

    public DocumentDTO toDto(Document entity){
        return  modelMapper.map(entity, DocumentDTO.class);
    }

    public Document toEntity(DocumentDTO dto){
        return modelMapper.map(dto, Document.class);
    }
}
