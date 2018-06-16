package com.example.alex_.hrcommunity;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

//database
@Database(entities = {Events.class}, version = 1)
public abstract class MyAppDatabase extends RoomDatabase {

    public abstract MyDao myDao();
}
