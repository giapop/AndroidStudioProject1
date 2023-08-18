package com.example.tema4dam.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.tema4dam.centre.CentruSanitar;

@Database(entities = {CentruSanitar.class},version = 1,exportSchema = false)
public abstract class DataBaseManager extends RoomDatabase {private static DataBaseManager dataBaseManager;

    public static DataBaseManager getInstance(Context context){
        if(dataBaseManager==null){
            synchronized (DataBaseManager.class){
                if(dataBaseManager==null){
                    dataBaseManager= Room.databaseBuilder(context,DataBaseManager.class,"db_tema4")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return dataBaseManager;
    }
    public abstract CentruSanitarDao getCentruDao();
}
