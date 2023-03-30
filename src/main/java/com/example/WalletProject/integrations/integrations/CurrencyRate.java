package com.example.WalletProject.integrations.integrations;

import com.google.gson.Gson;
import org.modelmapper.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class CurrencyRate
{
    private static URL url = null;
    private static URLConnection urlConnection = null;

    public static CurrencyForRate showCurrency(Long id) throws IOException {
        url = new URL("https://www.nbrb.by/api/exrates/currencies/"+ id);
        urlConnection = url.openConnection();
        return  new Gson()
                .fromJson
                        (new BufferedReader
                        (new InputStreamReader
                                (urlConnection.getInputStream())
                        ).readLine(),
                        CurrencyForRate.class);
    }

    public static Rate showRate(Integer id) throws IOException {
        url = new URL("https://www.nbrb.by/api/exrates/rates/"+id);
        urlConnection = url.openConnection();
        return new Gson()
                    .fromJson
                            (new BufferedReader
                            (new InputStreamReader
                                    (urlConnection.getInputStream())
                            ).readLine()
                            , Rate.class);
    }

    public static List<Rate> showAllAvailableRates() throws IOException {
        url = new URL("https://www.nbrb.by/api/exrates/rates?periodicity=0");
        urlConnection = url.openConnection();

        return   new ArrayList<>
                (new Gson()
                        .fromJson
                                (new BufferedReader
                                (new InputStreamReader
                                        (urlConnection.getInputStream())
                                ).readLine(),
                        new TypeToken<List
                                <CurrencyForRate>
                                >(){}.getType()));

    }
}
