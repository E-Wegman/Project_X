package com.example.alex_.hrcommunity;

import android.arch.persistence.room.*;
import java.util.List;
//functies om te doen met de tables
@Dao
public interface ActivityDao {
    //Returns everything in the database
    @Query("SELECT * FROM activity")
    List<Activity> getAll();

    //Returns everything ordered by date?? Or all in given tuples?? Idk plz test what does this do
    @Query("SELECT * FROM activity WHERE startYear IN (:actyears) AND startMonth IN (:actmonths) AND startDay IN (:actdays)")
    List<Activity> loadAllByDate(int[] actyears, int[] actmonths, int[] actdays);

    //Returns the activity found by name
    @Query("SELECT * FROM activity WHERE activityName LIKE :name LIMIT 1")
    Activity findByName(String name);

    //Return the activities in the given year
    @Query("SELECT * FROM activity WHERE startYear LIKE :year")
    Activity findByYear(int year);

    //Return the activities in given month
    @Query("SELECT * FROM activity WHERE startYear LIKE :year AND startMonth LIKE :month")
    Activity findByMonth(int year, int month);

    //Return the activities in given date
    @Query("SELECT * FROM activity WHERE startYear LIKE :year AND startMonth LIKE :month AND startDay LIKE :day")
    Activity findByDate(int year, int month, int day);


    @Insert
    void insertAll(Activity... activities);

    @Update
    public void updateActivity(Activity... activities);

    @Delete
    void delete(Activity activity);
}