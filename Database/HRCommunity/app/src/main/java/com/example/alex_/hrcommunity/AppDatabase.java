package com.example.alex_.hrcommunity;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.*;

//maakt de database

@Database(entities = {Activity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ActivityDao activityDao();
}

// To actually make a database
AppDatabase db = Room.databaseBuilder(getApplicationContext(),
      AppDatabase.class, "database-name").build();
