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
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Calendar;
import java.util.Locale;

public class Periodiek_Stap1 extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, AdapterView.OnItemSelectedListener{

    public static final String FIRST_DATE_YEAR_STAP1 = "com.example.alex_.hrcommunity.FIRST_DATE_YEAR_STAP1";
    public static final String FIRST_DATE_MONTH_STAP1 = "com.example.alex_.hrcommunity.FIRST_DATE_MONTH_STAP1";
    public static final String FIRST_DATE_DAY_STAP1 = "com.example.alex_.hrcommunity.FIRST_DATE_DAY_STAP1";
    public static final String PERIODE_LENGTESTAP1 = "com.example.alex_.hrcommunity.PERIODE_LENGTESTAP1";

    char begin = 'B';
    String startDateString;
    int periodeLengteInt;
    CheckBox cb;
    int startDateYearInt;
    int startDateMonthInt;
    int startDateDayInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periodiek__stap1);

        Button nextButton = findViewById(R.id.nextButton);
        Button veranderEersteDag = findViewById(R.id.veranderEersteDag);
        cb = findViewById(R.id.cbVakantieCheck);
        Spinner periodeLengte = (Spinner) findViewById(R.id.periodeLengte);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.semesterLengthArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        periodeLengte.setAdapter(adapter);
        periodeLengte.setOnItemSelectedListener(this);


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (startDateString == null) {
                    Toast.makeText(getApplicationContext(), "Vul de dagen in", Toast.LENGTH_SHORT).show();
                } else if (cb.isChecked()) {
                    openStap1_5();
                } else {
                    openStap2();
                }
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
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        startDateString = DateFormat.getDateInstance().format(c.getTime());
        TextView textView = (TextView) findViewById(R.id.beginPeriode);
        textView.setText(String.valueOf(startDateString));
        startDateYearInt = year;
        startDateMonthInt = month;
        startDateDayInt = dayOfMonth;

    }

    public void openStap1_5(){
        Intent intent = new Intent(Periodiek_Stap1.this, Periodiek_Stap1_5.class);
        intent.putExtra(FIRST_DATE_YEAR_STAP1, startDateYearInt);
        intent.putExtra(FIRST_DATE_MONTH_STAP1, startDateMonthInt);
        intent.putExtra(FIRST_DATE_DAY_STAP1, startDateDayInt);
        intent.putExtra(PERIODE_LENGTESTAP1, periodeLengteInt);
        startActivity(intent);
    }

    public void openStap2(){
        Intent intent = new Intent(Periodiek_Stap1.this, Periodiek_Stap2.class);
        intent.putExtra(FIRST_DATE_YEAR_STAP1, startDateYearInt);
        intent.putExtra(FIRST_DATE_MONTH_STAP1, startDateMonthInt);
        intent.putExtra(FIRST_DATE_DAY_STAP1, startDateDayInt);
        intent.putExtra(PERIODE_LENGTESTAP1, periodeLengteInt);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        parent.getItemAtPosition(position).toString();
        periodeLengteInt = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}


