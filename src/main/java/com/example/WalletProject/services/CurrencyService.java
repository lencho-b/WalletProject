package com.example.WalletProject.services;

import com.example.WalletProject.integrations.CurrencyRate;
import com.example.WalletProject.integrations.Rate;
import com.example.WalletProject.repositories.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CurrencyService
{
    @Autowired
    private final CurrencyRepository currencyRepository;

    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }
    public List<Rate> getAllAvailableRates() throws IOException {
        return CurrencyRate.showAllAvailableRates().stream()
                .filter(rate -> currencyRepository.findAll().stream()
                .anyMatch(currency -> currency.getId().compareTo(rate.getCur_ID())==0))
                .collect(Collectors.toList());
    }
    public Rate getRate(Integer id) throws IOException {
        return CurrencyRate.showRate(id);
    }
}
