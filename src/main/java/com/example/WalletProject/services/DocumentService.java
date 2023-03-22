package com.example.WalletProject.services;

import com.example.WalletProject.DTO.DocumentDTO;
import com.example.WalletProject.entity.Document;
import com.example.WalletProject.repositories.CountryRepository;
import com.example.WalletProject.repositories.DocumentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DocumentService
{
    private final DocumentRepository documentRepository;
    private final CountryRepository countryRepository;

    public DocumentService(DocumentRepository documentRepository, CountryRepository countryRepository) {
        this.documentRepository = documentRepository;
        this.countryRepository = countryRepository;
    }

    public DocumentDTO getDocumentByClientId(Long id)
    {
        Document document = documentRepository.getById(id);
        DocumentDTO documentDto =
                new DocumentDTO
                        (document.getDocumentNumber(),
                                document.getIssueDate(),
                                document.getCountry().getId());
        return documentDto;
    }
    public void createDocumentByClientId(Long id, DocumentDTO documentDto)
    {
        Document document = new Document();
        document.setClient_id(id);
        document.setDocumentNumber(documentDto.getDocumentNumber());
        document.setIssueDate(documentDto.getIssueDate());
        document.setCreatedAt(LocalDate.now());
        document.setCountry(countryRepository.getById(documentDto.getCountryId()));
        documentRepository.save(document);
    }
    public void deleteClientsDocumentByClientId(Long id)
    {
        Document document = documentRepository.getById(id);
        documentRepository.delete(document);
    }
}
