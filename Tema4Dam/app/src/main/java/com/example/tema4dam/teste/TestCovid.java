package com.example.tema4dam.teste;

import java.io.Serializable;

public class TestCovid implements Serializable {
    private int codTest;
    private String tipTest;
    private String rezultat;
    private String vaccinat;

    public TestCovid(int codTest, String tipTest, String rezultat, String vaccinat) {
        this.codTest = codTest;
        this.tipTest = tipTest;
        this.rezultat = rezultat;
        this.vaccinat = vaccinat;
    }

    public int getCodTest() {
        return codTest;
    }

    public void setCodTest(int codTest) {
        this.codTest = codTest;
    }

    public String getTipTest() {
        return tipTest;
    }

    public void setTipTest(String tipTest) {
        this.tipTest = tipTest;
    }

    public String getRezultat() {
        return rezultat;
    }

    public void setRezultat(String rezultat) {
        this.rezultat = rezultat;
    }

    public String getVaccinat() {
        return vaccinat;
    }

    public void setVaccinat(String vaccinat) {
        this.vaccinat = vaccinat;
    }

    @Override
    public String toString() {
        return "TestCovid{" +
                "codTest=" + codTest +
                ", tipTest='" + tipTest + '\'' +
                ", rezultat='" + rezultat + '\'' +
                ", vaccinat='" + vaccinat + '\'' +
                '}';
    }
}
