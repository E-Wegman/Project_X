package com.example.alex_.hrcommunity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SpinnerAdapter;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;



public class Periodiek_Stap2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener, TimePickerDialog.OnTimeSetListener{

    char begin = 'B';

    @Override
    protected void onCreate(Bundle savedInstanceState) {

       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_periodiek__stap2);

       Spinner weekDag = (Spinner) findViewById(R.id.weekDag);
       Button beginTijd = (Button) findViewById(R.id.startTijdVerander);
       Button eindTijd = (Button) findViewById(R.id.eindTijdVerander);

       ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.daysArray, android.R.layout.simple_spinner_item);
       adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

       weekDag.setAdapter(adapter);
       weekDag.setOnItemSelectedListener(this);

        beginTijd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                begin = 'B';
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");
            }
        });

        eindTijd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                begin = 'E';
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String dagen = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        if (begin == 'B'){
            TextView textView = (TextView)findViewById(R.id.beginTijdShow);
            textView.setText(hourOfDay + ":" + minute);
        }
        else{
            TextView textView = (TextView)findViewById(R.id.eindTijdShow);
            textView.setText(hourOfDay + ":" + minute);
        }

    }
}


