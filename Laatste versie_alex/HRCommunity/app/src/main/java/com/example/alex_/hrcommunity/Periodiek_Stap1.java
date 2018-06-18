package com.example.alex_.hrcommunity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Calendar;
import java.util.Locale;

public class Periodiek_Stap1 extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

char begin = 'B';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periodiek__stap1);

        Button nextButton = findViewById(R.id.nextButton);
        Button veranderEersteDag = findViewById(R.id.veranderEersteDag);
        Button veranderLaatsteDag = findViewById(R.id.veranderLaatsteDag);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Periodiek_Stap1.this, Periodiek_Stap1_5.class);
                startActivity(intent);
            }
        });

        veranderEersteDag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                begin = 'B';
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });

        veranderLaatsteDag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                begin = 'E';
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(),"date picker");
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance().format(c.getTime());

        if(begin == 'B'){
            TextView textView = (TextView) findViewById(R.id.beginPeriode);
            textView.setText(currentDateString);
        }
        else{
            TextView textView = (TextView) findViewById(R.id.eindePeriode);
            textView.setText(currentDateString);
        }

    }
}


