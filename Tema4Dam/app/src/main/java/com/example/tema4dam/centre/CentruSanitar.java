package com.example.tema4dam.centre;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "centre")
public class CentruSanitar implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private long id;
    @ColumnInfo
    private String judet;
    @ColumnInfo
    private String denumireUnitate;
    @ColumnInfo
    private int oraDeschiere;
    @ColumnInfo
    private int oraInchidere;

    public CentruSanitar(long id, String judet, String denumireUnitate, int oraDeschiere, int oraInchidere) {
        this.id = id;
        this.judet = judet;
        this.denumireUnitate = denumireUnitate;
        this.oraDeschiere = oraDeschiere;
        this.oraInchidere = oraInchidere;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Ignore
    public CentruSanitar(String judet, String denumireUnitate, int oraDeschiere, int oraInchidere) {
        this.judet = judet;
        this.denumireUnitate = denumireUnitate;
        this.oraDeschiere = oraDeschiere;
        this.oraInchidere = oraInchidere;
    }

    public String getJudet() {
        return judet;
    }

    public void setJudet(String judet) {
        this.judet = judet;
    }

    public String getDenumireUnitate() {
        return denumireUnitate;
    }

    public void setDenumireUnitate(String denumireUnitate) {
        this.denumireUnitate = denumireUnitate;
    }

    public int getOraDeschiere() {
        return oraDeschiere;
    }

    public void setOraDeschiere(int oraDeschiere) {
        this.oraDeschiere = oraDeschiere;
    }

    public int getOraInchidere() {
        return oraInchidere;
    }

    public void setOraInchidere(int oraInchidere) {
        this.oraInchidere = oraInchidere;
    }

    @Override
    public String toString() {
        return "CentruSanitar{" +
                "judet='" + judet + '\'' +
                ", denumireUnitate='" + denumireUnitate + '\'' +
                ", oraDeschiere=" + oraDeschiere +
                ", oraInchidere=" + oraInchidere +
                '}';
    }
}
