package com.example.alex_.hrcommunity;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.EventLog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class VeranderActivity extends AppCompatActivity {
    public static MyAppDatabase myAppDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verander);
        //Gets the event's id from prev screen
        int EventID = getIntent().getIntExtra("ID",0);
        //Makes the database again, idk if needed but hey
        myAppDatabase = Room.databaseBuilder(getApplicationContext(), MyAppDatabase.class, "Events" +
                "db").allowMainThreadQueries().build();
        ArrayList<Events> events = new ArrayList<Events>(VeranderActivity.myAppDatabase.myDao().getEvents());

        Button DeleteButt = findViewById(R.id.VerwijderButt);
        Button ChangeButt = findViewById(R.id.VeranderButt);
        TextView title = findViewById(R.id.VTitel);
        TextView bTijd = findViewById(R.id.VBeginTijd);
        TextView eTijd = findViewById(R.id.VEindTijd);
        TextView date = findViewById(R.id.VDatum);

        for (int i = 0; i < events.size(); i = i + 1) {
            Events CurrentEvent = events.get(i);
            if (EventID == CurrentEvent.getId()){
                title.setText(CurrentEvent.getTitel());
                bTijd.setText(CurrentEvent.getStart_tijd());
                eTijd.setText(CurrentEvent.getEind_tijd());
                date.setText(CurrentEvent.getDatum());
            }
        }


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
        ChangeButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Events> events = new ArrayList<Events>(VeranderActivity.myAppDatabase.myDao().getEvents());
                int EventID = getIntent().getIntExtra("ID",0);
                Intent intent = new Intent(v.getContext(), AddEventsActivity.class);
                String VTitel = "";
                String VBTijd = "";
                String VETijd = "";
                String VDate = "";
                for (int i = 0; i < events.size(); i = i + 1) {
                    Events CurrentEvent = events.get(i);
                    if (EventID == CurrentEvent.getId()){
                        VTitel = (CurrentEvent.getTitel());
                        VBTijd = (CurrentEvent.getStart_tijd());
                        VETijd= (CurrentEvent.getEind_tijd());
                        VDate = (CurrentEvent.getDatum());
                        MainActivity.myAppDatabase.myDao().deleteEvent(CurrentEvent);
                    }
                }
                intent.putExtra("Title", VTitel);
                intent.putExtra("BTijd", VBTijd);
                intent.putExtra("ETijd", VETijd);
                intent.putExtra("Date", VDate);

                v.getContext().startActivity(intent);
                finish();
            }
        });
    }
}
