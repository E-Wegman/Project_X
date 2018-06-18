package com.example.alex_.hrcommunity;

import android.app.AlarmManager;
import android.app.FragmentManager;
import android.app.PendingIntent;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    public static android.support.v4.app.FragmentManager fragmentManager;

    public static MyAppDatabase myAppDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent notificationIntent = new Intent(this, AlarmReceiver.class);
        PendingIntent broadcast = PendingIntent.getBroadcast(this, 100, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Calendar cal = Calendar.getInstance();
        //cal.set(Calendar.HOUR_OF_DAY, 14);
        //cal.set(Calendar.MINUTE, 4);
        //cal.set(Calendar.SECOND,1);
        cal.add(Calendar.SECOND, 10);

        alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), broadcast);

        fragmentManager = getSupportFragmentManager();
        //Main thread..
        myAppDatabase = Room.databaseBuilder(getApplicationContext(), MyAppDatabase.class, "eventsdb").allowMainThreadQueries().build();

        if(findViewById(R.id.fragment_container)!=null){
            if(savedInstanceState!= null){
                return;
            }
            fragmentManager.beginTransaction().add(R.id.fragment_container, new HomeFragment()).commit();
        }

    }


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


}
