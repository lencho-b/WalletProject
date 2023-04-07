package com.example.WalletProject.services;

import com.example.WalletProject.integration.CurrencyRate;
import com.example.WalletProject.integration.Rate;
import com.example.WalletProject.models.Entity.Currency;
import com.example.WalletProject.repositories.CurrencyRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class CurrencyService
{
    private final CurrencyRepository currencyRepository;

    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }
    public List<Rate> getAllAvailableRates() throws IOException {
        List<Currency>currenciesFromDB = currencyRepository.findAll();
        List<Rate>ratesFromApi = CurrencyRate.showAllAvailableRates();
        return ratesFromApi.stream().filter(rate -> currenciesFromDB.stream().
                anyMatch(rates -> rates.getIdFromApi().compareTo(rate.getCur_ID())==0)).toList();
    }

    public BigDecimal exchangeValue(Long transactionValue, Rate firstRate,Rate secondRate) {
     return new BigDecimal(transactionValue)
             .multiply(firstRate.getCur_OfficialRate())
             .divide(new BigDecimal(firstRate.getCur_Scale()),RoundingMode.HALF_UP)
             .divide(secondRate.getCur_OfficialRate(),RoundingMode.HALF_UP)
             .divide(new BigDecimal(secondRate.getCur_Scale()),RoundingMode.HALF_UP);
    }
}
