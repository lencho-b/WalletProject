package com.example.WalletProject.services;

import com.example.WalletProject.exceptions.CountryNotFoundException;
import com.example.WalletProject.exceptions.DocumentNotFoundException;
import com.example.WalletProject.models.DTO.DocumentDto;
import com.example.WalletProject.models.Entity.Document;
import com.example.WalletProject.repositories.CountryRepository;
import com.example.WalletProject.repositories.DocumentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DocumentService {
    private final DocumentRepository documentRepository;
    private final CountryRepository countryRepository;
    private final ModelMapper modelMapper;

    public DocumentService(DocumentRepository documentRepository, CountryRepository countryRepository, ModelMapper modelMapper) {
        this.documentRepository = documentRepository;
        this.countryRepository = countryRepository;
        this.modelMapper = modelMapper;
    }

    public DocumentDto getDocumentByClientId(Long id) {

        Document document = findOrThrow(id);
        DocumentDto documentDto = modelMapper.map(document, DocumentDto.class);
        documentDto.setCountry(document.getCountry().getName());
        return documentDto;
    }

    public void createDocumentByClientId(Long id, DocumentDto documentDto) {
        //проверка валидации
        Document document = modelMapper.map(documentDto, Document.class);
        document.setClient_id(id);

        document.setCountry(countryRepository.findByName(documentDto.getCountry())
                .orElseThrow(() -> new CountryNotFoundException("Country not found")));
        document.setCreatedAt(LocalDate.now());
        documentRepository.save(document);
    }

    public void deleteClientsDocumentByClientId(Long id) {
        Document document = findOrThrow(id);
        documentRepository.delete(document);
    }

    private Document findOrThrow(Long id) {
        return documentRepository.findById(id).orElseThrow(() -> new DocumentNotFoundException("Document with id "+id+" not found"));
    }
}