package com.example.WalletProject.services;

import com.example.WalletProject.models.DTO.DocumentDto;
import com.example.WalletProject.models.Entity.Document;
import com.example.WalletProject.repositories.CountryRepository;
import com.example.WalletProject.repositories.DocumentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DocumentService {
    private final DocumentRepository documentRepository;
    private final CountryRepository countryRepository;

    public DocumentService(DocumentRepository documentRepository, CountryRepository countryRepository) {
        this.documentRepository = documentRepository;
        this.countryRepository = countryRepository;
    }

    // Здесь лямбда усложнит читаемость кода, я просто сделал этот метод немного компактнее
    public DocumentDto getDocumentByClientId(Long id) {
        Document document = documentRepository.getById(id);
        return new DocumentDto(
                document.getDocumentNumber(),
                document.getIssueDate(),
                document.getCountry().getId()
        );
    }

    public void createDocumentByClientId(Long id, DocumentDto documentDto) {
        Document document = new Document();
        document.setClient_id(id);
        document.setDocumentNumber(documentDto.getDocumentNumber());
        document.setIssueDate(documentDto.getIssueDate());
        document.setCreatedAt(LocalDate.now());
        document.setCountry(countryRepository.getById(documentDto.getCountryId()));
        documentRepository.save(document);
    }

    public void deleteClientsDocumentByClientId(Long id) {
        Document document = documentRepository.getById(id);
        documentRepository.delete(document);
    }
}