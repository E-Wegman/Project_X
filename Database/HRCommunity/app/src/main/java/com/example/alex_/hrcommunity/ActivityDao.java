package com.example.alex_.hrcommunity;
import android.arch.persistence.room.*;
import java.util.List;

//All queries and functions
@Dao
public interface ActivityDao {
    //Returns everything in the database in an Array
    @Query("SELECT * FROM activity")
    List<Activity> getAll();

    //Should return anything in the given date in an Array
    @Query("SELECT * FROM activity WHERE startYear IN (:actYears) AND startMonth IN (:actMonths) AND startDay IN (:actDays)")
    List<Activity> loadAllByDate(int[] actYears, int[] actMonths, int[] actDays);

    //Return the activities in the given year in an Array
    @Query("SELECT * FROM activity WHERE startYear LIKE :year")
    List<Activity> findByYear(int year);

    //Return the activities in the given month in an Array
    @Query("SELECT * FROM activity WHERE startYear LIKE :year AND startMonth LIKE :month")
    List<Activity> findByMonth(int year, int month);

    //Return the activities in the given date in an Array
    @Query("SELECT * FROM activity WHERE startYear LIKE :year AND startMonth LIKE :month AND startDay LIKE :day")
    List<Activity> findByDate(int year, int month, int day);

    //Returns the activity found by ID. Not an Array
    @Query("SELECT * FROM activity WHERE aid LIKE :id LIMIT 1")
    Activity findByID(int id);

    //Inserts all activities
    @Insert
    void insertAll(Activity... activities);

    //Updates all activities
    @Update
    void updateActivity(Activity... activities);

    //Deletes given activity
    @Delete
    void delete(Activity activity);
}