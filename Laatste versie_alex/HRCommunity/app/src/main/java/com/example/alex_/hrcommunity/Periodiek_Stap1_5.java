package com.example.alex_.hrcommunity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class Periodiek_Stap1_5 extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, AdapterView.OnItemSelectedListener{
    public static final String FIRST_DATE_YEAR_STAP1_5 = "com.example.alex_.hrcommunity.FIRST_DATE_YEAR_STAP1_5";
    public static final String FIRST_DATE_MONTH_STAP1_5 = "com.example.alex_.hrcommunity.FIRST_DATE_MONTH_STAP1_5";
    public static final String FIRST_DATE_DAY_STAP1_5 = "com.example.alex_.hrcommunity.FIRST_DATE_DAY_STAP1_5";
    public static final String PERIODE_LENGTE_STAP1_5 = "com.example.alex_.hrcommunity.PERIODE_LENGTE_STAP1_5";
    public static final String VACATION_LENGTH_STAP1_5 = "com.example.alex_hrcommunity.VACTION_LENGTH";
    public static final String FROM_STAP1_5 = "com.example.alex_hrcommunity.PERIODE_LENGTE_STAP1_5";
    public static final String VACATION_START_MONTH = "com.example.alex_hrcommunity.VACATION_START_MONTH";
    public static final String VACATION_START_DAY = "com.example.alex_hrcommunity.VACATION_START_DAY";
    public static final String VACATION_START_YEAR = "com.example.alex_hrcommunity.VACATION_START_YEAR";

    String vacationStartDateString;
    int vacationStartMonthInt;
    int vacationStartDayInt;
    int vacationStartYearInt;
    int startDateYearInt;
    int startDateMonthInt;
    int startDateDayInt;
    int periodeLengte;
    int vacationLength;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periodiek__stap1_5);

        Intent intent = getIntent();
        startDateYearInt = intent.getIntExtra(Periodiek_Stap1.FIRST_DATE_YEAR_STAP1, 0);
        startDateMonthInt = intent.getIntExtra(Periodiek_Stap1.FIRST_DATE_MONTH_STAP1, 0);
        startDateDayInt = intent.getIntExtra(Periodiek_Stap1.FIRST_DATE_DAY_STAP1, 0);
        periodeLengte = intent.getIntExtra(Periodiek_Stap1.PERIODE_LENGTESTAP1, 0);

        Spinner vakantieLengte = (Spinner) findViewById(R.id.vakantieLengte);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.vacationLengthArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        vakantieLengte.setAdapter(adapter);
        vakantieLengte.setOnItemSelectedListener(this);

        Button nextButton = findViewById(R.id.nextButton);
        Button veranderVakantie = findViewById(R.id.veranderBeginVakantie);


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vacationStartDateString == null || vacationLength == 0) {
                    Toast.makeText(getApplicationContext(), "Vul de dagen in", Toast.LENGTH_SHORT).show();
                } else {
                    open_stap2();
                }
            }
        });

        veranderVakantie.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        vacationStartDateString = DateFormat.getDateInstance().format(c.getTime());
        TextView textView = (TextView) findViewById(R.id.vakantieBegin);
        textView.setText(vacationStartDateString);

        vacationStartYearInt = year;
        vacationStartMonthInt = month;
        vacationStartDayInt = dayOfMonth;

    }


    //position can be calculated with, position makes first item 0, second item 1, third item 2 and so on
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        parent.getItemAtPosition(position).toString();
        vacationLength = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void open_stap2(){
        Intent intent = new Intent(Periodiek_Stap1_5.this, Periodiek_Stap2.class);
        intent.putExtra(FIRST_DATE_YEAR_STAP1_5, startDateYearInt);
        intent.putExtra(FIRST_DATE_MONTH_STAP1_5, startDateMonthInt);
        intent.putExtra(FIRST_DATE_DAY_STAP1_5, startDateDayInt);
        intent.putExtra(PERIODE_LENGTE_STAP1_5, periodeLengte);
        intent.putExtra(VACATION_START_DAY, vacationStartDayInt);
        intent.putExtra(VACATION_START_MONTH, vacationStartMonthInt);
        intent.putExtra(VACATION_START_YEAR, vacationStartYearInt);
        intent.putExtra(VACATION_LENGTH_STAP1_5, vacationLength);
        intent.putExtra(FROM_STAP1_5, true);
        startActivity(intent);
    }
}
