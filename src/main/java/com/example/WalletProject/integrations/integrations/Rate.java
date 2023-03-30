package com.example.WalletProject.integrations.integrations;

import java.math.BigDecimal;

public class Rate
{
    private String Cur_Abbreviation;
    private Integer Cur_Scale;
    private String Cur_Name;
    private BigDecimal Cur_OfficialRate;

    public Rate(String cur_Abbreviation, Integer cur_Scale, String cur_Name, BigDecimal cur_OfficialRate) {
        Cur_Abbreviation = cur_Abbreviation;
        Cur_Scale = cur_Scale;
        Cur_Name = cur_Name;
        Cur_OfficialRate = cur_OfficialRate;
    }

    public Rate() {
    }
    public String getCur_Abbreviation() {
        return Cur_Abbreviation;
    }

    public void setCur_Abbreviation(String cur_Abbreviation) {
        Cur_Abbreviation = cur_Abbreviation;
    }

    public Integer getCur_Scale() {
        return Cur_Scale;
    }

    public void setCur_Scale(Integer cur_Scale) {
        Cur_Scale = cur_Scale;
    }

    public String getCur_Name() {
        return Cur_Name;
    }

    public void setCur_Name(String cur_Name) {
        Cur_Name = cur_Name;
    }

    public BigDecimal getCur_OfficialRate() {
        return Cur_OfficialRate;
    }

    public void setCur_OfficialRate(BigDecimal cur_OfficialRate) {
        Cur_OfficialRate = cur_OfficialRate;
    }

    @Override
    public String toString() {
        return "Rate{" +
                ", Cur_Abbreviation='" + Cur_Abbreviation + '\'' +
                ", Cur_Scale=" + Cur_Scale +
                ", Cur_Name='" + Cur_Name + '\'' +
                ", Cur_OfficialRate=" + Cur_OfficialRate +
                '}';
    }
}