package com.example.tema4dam.database;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.tema4dam.centre.CentruSanitar;

@Dao
public interface CentruSanitarDao {

    @Insert
    long insert(CentruSanitar centruSanitar);

}
