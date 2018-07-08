package com.example.alex_.hrcommunity;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.EventLog;

import java.util.ArrayList;

public class VeranderActivity extends AppCompatActivity {
    public static MyAppDatabase myAppDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verander);
        int EventID = getIntent().getIntExtra("ID",0);

        //Delete function in onCreate
        myAppDatabase = Room.databaseBuilder(getApplicationContext(), MyAppDatabase.class, "Events" +
                "db").allowMainThreadQueries().build();

        ArrayList<Events> events = new ArrayList<Events>(VeranderActivity.myAppDatabase.myDao().getEvents());

        for (int i = 0; i < events.size(); i = i + 1) {
            Events CurrentEvent = events.get(i);
            if (EventID == CurrentEvent.getId()){
                MainActivity.myAppDatabase.myDao().deleteEvent(CurrentEvent);
            }
        }

        //Show Item's title, time and date

        //Make Delete on buttonclick

        //Make Change on buttonclick

    }
}
