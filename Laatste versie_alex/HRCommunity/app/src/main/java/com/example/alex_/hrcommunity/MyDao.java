package com.example.alex_.hrcommunity;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface MyDao {

    @Insert
    public void addEvents(Events events);

    @Query("select * from event")
    public List<Events> getEvents();

    @Delete
    public void deleteEvent(Events events);

    @Update
    public void updateEvent(Events events);

 /*   //Should return anything in the given date in an Array
    @Query("SELECT * FROM activity WHERE startYear IN (:actYears) AND startMonth IN (:actMonths) AND startDay IN (:actDays)")
    List<Events> loadAllByDate(int[] actYears, int[] actMonths, int[] actDays);

    //Return the activities in the given year in an Array
    @Query("SELECT * FROM activity WHERE startYear LIKE :year")
    List<Events> findByYear(int year);

    //Return the activities in the given month in an Array
    @Query("SELECT * FROM activity WHERE startYear LIKE :year AND startMonth LIKE :month")
    List<Events> findByMonth(int year, int month);

    //Return the activities in the given date in an Array
    @Query("SELECT * FROM activity WHERE startYear LIKE :year AND startMonth LIKE :month AND startDay LIKE :day")
    List<Events> findByDate(int year, int month, int day);

    //Returns the activity found by ID. Not an Array
    @Query("SELECT * FROM activity WHERE aid LIKE :id LIMIT 1")
    List<Events> findByID(int id);*/


}
