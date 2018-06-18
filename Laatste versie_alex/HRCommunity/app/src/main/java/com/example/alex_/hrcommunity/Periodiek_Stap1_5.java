package com.example.alex_.hrcommunity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class Periodiek_Stap1_5 extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periodiek__stap1_5);

        radioGroup = findViewById(R.id.radioGroup);
        //textView = findViewById(R.id.text_view_selected);
        Button toevoegVakantie = findViewById(R.id.veranderBeginVakantie);
        Button nextButton = findViewById(R.id.nextButton);


        toevoegVakantie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);
            }
        });

        toevoegVakantie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Periodiek_Stap1_5.this, Periodiek_Stap2.class);
                startActivity(intent);
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
            TextView textView = (TextView) findViewById(R.id.vakantieBegin);
            textView.setText(currentDateString);

        }
}
