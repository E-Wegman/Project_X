package com.example.alex_.hrcommunity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class EventActivity extends AppCompatActivity {

    private static final String TAG = "CalendarActivity";

    //final Button button = (Button) findViewById(R.id.toevoegen);
    //EditText text = (EditText) findViewById(R.id.activiteit);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_layout);

        /*
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String content = text.getText().toString(); //gets you the contents of edit text
                Activity inputItem = new Activity();
                inputItem.setActivityName(content);
            }
        }); */
    }

}