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

public class MainActivity extends AppCompatActivity {

    public static android.support.v4.app.FragmentManager fragmentManager;

    public static MyAppDatabase myAppDatabase;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapater;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton add = findViewById(R.id.evenementenToevoegen);

        //maakt arraylist aan en vult hier 1 item in om te testen -> item later weghalen wanneer data out database wordt gehaald
        ArrayList<EvenementenReader> evenementenList = new ArrayList<>();
        evenementenList.add(new EvenementenReader("Titel", "12:40", "15:40", "12 mei 2018"));

        //make for loop that gets the data out of the database
        /*MainActivity.myAppDatabase.myDao().getEvents();
        EEventTitel.setText("");
        EventStartTijd.setText("");
        EventEindTijd.setText("");
        EventDatum.setText("");
*/



//zorgt voor de view dat deze goed wordt gehandeld
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapater = new EvenementenAdapter(evenementenList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapater);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddEventsActivity.class);
                startActivity(intent);
            }
        });
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


  @SuppressWarnings("StatementWithEmptyBody")

   public void onNavigationItemSelected(MenuItem item) {

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {

        } else if (id == R.id.nav_agenda) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

  }
*/

}
