package com.example.WalletProject.services;

import com.example.WalletProject.exceptions.CountryNotFoundException;
import com.example.WalletProject.models.DTO.country.FullCountryInfoDto;
import com.example.WalletProject.models.Entity.Country;
import com.example.WalletProject.models.Entity.DocumentFormat;
import com.example.WalletProject.repositories.CountryRepository;
import com.example.WalletProject.repositories.DocumentFormatRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CountryService {
    private final CountryRepository countryRepository;
    private final ModelMapper modelMapper;
    private final DocumentFormatRepository documentFormatRepository;

    public CountryService(CountryRepository countryRepository, ModelMapper modelMapper, DocumentFormatRepository documentFormatRepository) {
        this.countryRepository = countryRepository;
        this.modelMapper = modelMapper;

        this.documentFormatRepository = documentFormatRepository;
    }

    public Page<FullCountryInfoDto> findAll(Pageable pageable) {
        Page<Country> page = countryRepository.findAll(pageable);
        return new PageImpl<>(page.getContent().stream()
                .map(country -> modelMapper.map(country, FullCountryInfoDto.class))
                .collect(Collectors.toList()));
    }

    public FullCountryInfoDto findByName(String name) {
        Optional<Country> country = countryRepository.findByName(name);
        if (country.isPresent()) {
            return modelMapper.map(country.get(), FullCountryInfoDto.class);
        }

        throw new CountryNotFoundException("Country " + name + " not found");
    }

    public void saveOrUpdate(FullCountryInfoDto countryInfoDto) {
        Country country = modelMapper.map(countryInfoDto, Country.class);
        Optional<Country> optional = countryRepository.findByName(country.getName());
        Country toBeUpdated = optional.get();
        if (optional.isPresent()) {
            toBeUpdated.setName(country.getName());
            toBeUpdated.setPhoneCode(country.getPhoneCode());
            Optional<DocumentFormat> documentOptional = documentFormatRepository
                    .findByDocumentFormat(country.getDocumentFormat().getDocumentFormat());
            if (documentOptional.isEmpty()) {
                documentFormatRepository.save(country.getDocumentFormat());
            }
            documentOptional = documentFormatRepository
                    .findByDocumentFormat(country.getDocumentFormat().getDocumentFormat());
            toBeUpdated.setDocumentFormat(documentOptional.get());
            countryRepository.save(toBeUpdated);
        } else {
            throw new CountryNotFoundException("Country not found");
        }
    }

    public void deleteCountry(String name) {
        Optional<Country> country = countryRepository.findByName(name);
        Optional<DocumentFormat> documentFormat = documentFormatRepository
                .findByDocumentFormat(country.get().getDocumentFormat().getDocumentFormat());
        documentFormatRepository.delete(documentFormat.get());
        country.ifPresent(value -> countryRepository.deleteById(value.getId()));
    }

}
