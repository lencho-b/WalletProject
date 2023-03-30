package com.example.WalletProject.integrations.integrations;

public class CurrencyForRate
{
    private Long Cur_ID;
    private String Cur_Abbreviation;
    private String Cur_Name;

    public CurrencyForRate(Long cur_ID, String cur_Abbreviation, String cur_Name) {
        Cur_ID = cur_ID;
        Cur_Abbreviation = cur_Abbreviation;
        Cur_Name = cur_Name;
    }

    public CurrencyForRate() {
    }

    public Long getCur_ID() {
        return Cur_ID;
    }

    public void setCur_ID(Long cur_ID) {
        Cur_ID = cur_ID;
    }

    public String getCur_Abbreviation() {
        return Cur_Abbreviation;
    }

    public void setCur_Abbreviation(String cur_Abbreviation) {
        Cur_Abbreviation = cur_Abbreviation;
    }

    public String getCur_Name() {
        return Cur_Name;
    }

    public void setCur_Name(String cur_Name) {
        Cur_Name = cur_Name;
    }

}