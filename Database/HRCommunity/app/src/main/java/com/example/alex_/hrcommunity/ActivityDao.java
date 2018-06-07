package com.example.alex_.hrcommunity;

import android.arch.persistence.room.*;
import java.util.List;
//functies om te doen met de tables
@Dao
public interface ActivityDao {
    @Query("SELECT * FROM activity")
    List<Activity> getAll();

    @Query("SELECT * FROM activity WHERE aid IN (:actIds)")
    List<Activity> loadAllByIds(int[] actIds);

    //@Query("SELECT * FROM activity WHERE activityName LIKE :first AND "
    //        + "last_name LIKE :last LIMIT 1")
    //User findByName(String first, String last);

    @Insert
    void insertAll(Activity... activities);

    @Update
    public void updateActivity(Activity... activities);

    @Delete
    void delete(Activity activity);
}