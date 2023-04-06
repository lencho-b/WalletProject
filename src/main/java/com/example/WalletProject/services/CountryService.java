package com.example.WalletProject.services;

import com.example.WalletProject.exceptions.CountryNotFoundException;
import com.example.WalletProject.models.Entity.Country;
import com.example.WalletProject.repositories.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    public Country findByName(String name) {
        return countryRepository.findByName(name).orElseThrow(() -> new CountryNotFoundException("Country " + name + " not found"));
    }

    public void saveOrUpdate(Country country) {
        Optional<Country> toBeUpdated = countryRepository.findByName(country.getName());
        toBeUpdated.ifPresent(value -> country.setId(value.getId()));
        countryRepository.save(country);
    }

    public void deleteCountry(String name) {
        Optional<Country> country = countryRepository.findByName(name);
        country.ifPresent(value -> countryRepository.deleteById(value.getId()));
    }

}
