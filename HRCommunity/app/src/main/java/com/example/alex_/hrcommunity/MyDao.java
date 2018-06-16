package com.example.alex_.hrcommunity;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface MyDao {

    @Insert
    public void addEvents(Events events);

    @Query("select * from event")
    public List<Events> getEvents();




}
