package com.example.alex_.hrcommunity;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.EventLog;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class VeranderActivity extends AppCompatActivity {
    public static MyAppDatabase myAppDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verander);
        int EventID = getIntent().getIntExtra("ID",0);

        Button DeleteButt = findViewById(R.id.VerwijderButt);
        Button ChangeButt = findViewById(R.id.VeranderButt);

        myAppDatabase = Room.databaseBuilder(getApplicationContext(), MyAppDatabase.class, "Events" +
                "db").allowMainThreadQueries().build();

        //Show Item's title, time and date

        DeleteButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Events> events = new ArrayList<Events>(VeranderActivity.myAppDatabase.myDao().getEvents());
                int EventID = getIntent().getIntExtra("ID",0);
                for (int i = 0; i < events.size(); i = i + 1) {
                    Events CurrentEvent = events.get(i);
                    if (EventID == CurrentEvent.getId()){
                        MainActivity.myAppDatabase.myDao().deleteEvent(CurrentEvent);
                    }
                }
                finish();
            }
        });

        //Make Change on buttonclick

    }
}
