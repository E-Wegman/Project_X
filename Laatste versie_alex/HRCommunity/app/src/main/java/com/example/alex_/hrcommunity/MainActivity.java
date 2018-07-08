package com.example.alex_.hrcommunity;

import android.app.FragmentManager;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static MyAppDatabase myAppDatabase;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapater;
    private RecyclerView.LayoutManager mLayoutManager;

    Events evenement = new Events();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//Maakt de database aan!
        myAppDatabase = Room.databaseBuilder(getApplicationContext(), MyAppDatabase.class, "Events" +
                "db").allowMainThreadQueries().build();

//zet alle gedeelten van de UI op een variabele
        FloatingActionButton add = findViewById(R.id.evenementenToevoegen);

        run();

// De onClicklistener zorgt ervoor dat de knoppen wat doen
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddEventsActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onRestart() {
        super.onRestart();
        //When BACK BUTTON is pressed, the activity on the stack is restarted
        run();
    }


    public void run(){
        //maakt arraylist aan en vult hier 1 item in om te testen -> item later weghalen wanneer data out database wordt gehaald
        ArrayList<EvenementenReader> evenementenAl = new ArrayList<>();

//make for loop that gets the data out of the database
        ArrayList<Events> events = new ArrayList<Events>(MainActivity.myAppDatabase.myDao().getEvents());

        for (int i = 0; i < events.size(); i = i + 1) {
            int eID = events.get(i).getId();
            String eTitel = events.get(i).getTitel();
            String eStartTijd = events.get(i).getStart_tijd();
            String eEindTijd = events.get(i).getEind_tijd();
            String eDatum = events.get(i).getDatum();
            String eKleur = events.get(i).getKleur();
            int ePrioriteit = events.get(i).getPrioriteit();

            evenementenAl.add(new EvenementenReader(eTitel, eStartTijd, eEindTijd, eDatum, eID, ePrioriteit, eKleur));
        }

//zorgt voor de view dat deze goed wordt gehandeld
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapater = new EvenementenAdapter(evenementenAl);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapater);
    }
}