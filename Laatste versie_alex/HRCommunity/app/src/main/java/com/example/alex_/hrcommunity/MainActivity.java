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

//Maakt de database aan?
        myAppDatabase = Room.databaseBuilder(getApplicationContext(), MyAppDatabase.class, "eventsdb").allowMainThreadQueries().build();

//zet alle gedeelten van de UI op een variabele
        FloatingActionButton add = findViewById(R.id.evenementenToevoegen);



//maakt arraylist aan en vult hier 1 item in om te testen -> item later weghalen wanneer data out database wordt gehaald
        ArrayList<EvenementenReader> evenementenAl = new ArrayList<>();
        evenementenAl.add(new EvenementenReader("Titel", "12:40", "15:40", "12 mei 2018"));

//make for loop that gets the data out of the database
        List<Events> events = MainActivity.myAppDatabase.myDao().getEvents();

        for (int i = 0; i < events.size(); i = i + 1) {
            String eTitel = evenement.getTitel();
            String eStartTijd = evenement.getStart_tijd();
            String eEindTijd = evenement.getEind_tijd();
            String eDatum = evenement.getDatum();
            evenementenAl.add(new EvenementenReader(eTitel, eStartTijd, eEindTijd, eDatum));
        }

//zorgt voor de view dat deze goed wordt gehandeld
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapater = new EvenementenAdapter(evenementenAl);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapater);


// De onClicklistener zorgt ervoor dat de knoppen wat doen
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddEventsActivity.class);
                startActivity(intent);
            }
        });
    }
/*
    public void onRestart(){
        super.onRestart();
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapater = new EvenementenAdapter(evenementenAl);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapater);
    }
*/
}
