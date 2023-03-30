package com.example.WalletProject.services;

import com.example.WalletProject.models.DTO.DocumentDto;
import com.example.WalletProject.models.Entity.Document;
import com.example.WalletProject.repositories.CountryRepository;
import com.example.WalletProject.repositories.DocumentRepository;
import jakarta.persistence.EntityNotFoundException;
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

        return modelMapper.map(document, DocumentDto.class);
    }

    public void createDocumentByClientId(Long id, DocumentDto documentDto) {
        //проверка валидации
        Document document = modelMapper.map(documentDto, Document.class);
        document.setClient_id(id);
//        document.setDocumentNumber(documentDto.getDocumentNumber());
//        document.setIssueDate(documentDto.getIssueDate());
//        document.setCreatedAt(LocalDate.now());
        document.setCountry(countryRepository.findByName(documentDto.getCountry().getName())
                .orElseThrow(() -> new EntityNotFoundException("Country not found")));
        documentRepository.save(document);
    }

    public void deleteClientsDocumentByClientId(Long id) {
        Document document = findOrThrow(id);
        documentRepository.delete(document);
    }

    private Document findOrThrow(Long id) {
        return documentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Document not found"));
    }
}