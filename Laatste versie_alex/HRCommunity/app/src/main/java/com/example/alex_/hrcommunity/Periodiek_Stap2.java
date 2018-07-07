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
import android.widget.EditText;
import android.widget.SpinnerAdapter;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;



public class Periodiek_Stap2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener, TimePickerDialog.OnTimeSetListener{

    char begin = 'B';
    String startTimeView, endTimeView, firstVacationDateString, dagVanDeWeekString, vakNaamText, lokaalNaamText, fromStap1_5, datum;
    int vacationLength, dagVanDeWeekInt, periodeLengte, startDateYearInt, startDateMonthInt, startDateDayInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periodiek__stap2);

        //variabelen uit vorige activities worden opgehaald
        Intent intent = getIntent();
        fromStap1_5 = intent.getStringExtra(Periodiek_Stap1_5.FROM_STAP1_5);

        firstVacationDateString = intent.getStringExtra(Periodiek_Stap1_5.FIRST_VACATION_DATE_STAP1_5);
        vacationLength = intent.getIntExtra(Periodiek_Stap1_5.VACATION_LENGTH_STAP1_5, 0);
        if (fromStap1_5 == "TRUE"){
            periodeLengte = intent.getIntExtra(Periodiek_Stap1_5.PERIODE_LENGTE_STAP1_5, 0);
            startDateYearInt = intent.getIntExtra(Periodiek_Stap1_5.FIRST_DATE_YEAR_STAP1_5, 0);
            startDateMonthInt = intent.getIntExtra(Periodiek_Stap1_5.FIRST_DATE_MONTH_STAP1_5, 0);
            startDateDayInt = intent.getIntExtra(Periodiek_Stap1_5.FIRST_DATE_DAY_STAP1_5, 0);
        }
        else{
            periodeLengte = intent.getIntExtra(Periodiek_Stap1.PERIODE_LENGTESTAP1, 0);
            startDateYearInt = intent.getIntExtra(Periodiek_Stap1.FIRST_DATE_YEAR_STAP1, 0);
            startDateMonthInt = intent.getIntExtra(Periodiek_Stap1.FIRST_DATE_MONTH_STAP1, 0);
            startDateDayInt = intent.getIntExtra(Periodiek_Stap1.FIRST_DATE_DAY_STAP1, 0);

        }

        //variabelen voor de knoppen en spinner worden aangemaakt
        EditText vakNaamTextView = findViewById(R.id.vakNaam);
        vakNaamText = vakNaamTextView.getText().toString();
        EditText lokaalNaamTextView = findViewById(R.id.lokaalNaamText);
        lokaalNaamText = lokaalNaamTextView.getText().toString();

        Spinner weekDag = (Spinner) findViewById(R.id.weekDag);
        Button beginTijd = (Button) findViewById(R.id.startTijdVerander);
        Button eindTijd = (Button) findViewById(R.id.eindTijdVerander);
        Button voegToe = (Button) findViewById(R.id.periodeToevoegenButton);

        //Array adapter, haalt het op uit: res ->values->strings.xml
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.daysArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        weekDag.setAdapter(adapter);
        weekDag.setOnItemSelectedListener(this);

        //Knopjes om tijd aan te passen
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

        voegToe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toevoegen();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        dagVanDeWeekString = parent.getItemAtPosition(position).toString();
        dagVanDeWeekInt = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        if (begin == 'B'){
            startTimeView = hourOfDay + ":" + minute;
            TextView textView = (TextView)findViewById(R.id.beginTijdShow);
            textView.setText(startTimeView);
        }

        else{
            endTimeView = hourOfDay + ":" + minute;
            TextView textView = (TextView)findViewById(R.id.eindTijdShow);
            textView.setText(endTimeView);
        }
    }

    public void toevoegen(){
        String samenvoegingTitel = vakNaamText + " - " + lokaalNaamText;
        for (int i = -5; i < periodeLengte; i++){
            switch (dagVanDeWeekInt){
                case 0:
                    startDateDayInt = startDateDayInt + (dagVanDeWeekInt * 7);
                    periodeToevoegen(samenvoegingTitel);
                    //its monday
                    break;

                case 1:
                    startDateDayInt = startDateDayInt + 1 + (dagVanDeWeekInt * 7);
                    periodeToevoegen(samenvoegingTitel);
                    //its tuesday
                    break;
                case 2:
                    startDateDayInt = startDateDayInt + 2 + (dagVanDeWeekInt * 7);
                    periodeToevoegen(samenvoegingTitel);
                    //its wednesday
                    break;
                case 3:
                    startDateDayInt = startDateDayInt + 3 + (dagVanDeWeekInt * 7);
                    periodeToevoegen(samenvoegingTitel);
                    //its thursday
                    break;
                case 4:
                    startDateDayInt = startDateDayInt + 4 + (dagVanDeWeekInt * 7);
                    periodeToevoegen(samenvoegingTitel);
                    // its friday
                    break;
            }
        }


    }

    private void periodeToevoegen(String samenvoegingTitel) {
        Calendar c;
        monthChoose(startDateYearInt, startDateMonthInt, startDateDayInt);
        c = Calendar.getInstance();
        c.set(Calendar.YEAR, startDateYearInt);
        c.set(Calendar.MONTH, startDateMonthInt);
        c.set(Calendar.DAY_OF_MONTH, startDateDayInt);

        datum = DateFormat.getDateInstance().format(c.getTime());

        setDataInDB(samenvoegingTitel, startTimeView, endTimeView, datum);
    }

    public void setDataInDB(String titel,String starttijd,String eindtijd,String datum){
        Events events = new Events();
        events.setTitel(titel);
        events.setStart_tijd(starttijd);
        events.setEind_tijd(eindtijd);
        events.setDatum(datum);

        MainActivity.myAppDatabase.myDao().addEvents(events);

    }

    public void monthChoose(int year, int month, int day){
        switch (month){
            case 0:
            case 2:
            case 4:
            case 6:
            case 7:
            case 9:
                if (day >= 31){
                    startDateMonthInt = startDateMonthInt + 1;
                    startDateDayInt = 0 + (day - 31);
                }
            break;

            case 11:
                if (day >= 31){
                    startDateYearInt = startDateYearInt + 1;
                    startDateMonthInt = startDateMonthInt + 1;
                    startDateDayInt = 0 + (day - 31);
                }

            case 3:
            case 5:
            case 8:
            case 10:
                if (day >= 30){
                    startDateMonthInt = startDateMonthInt + 1;
                    startDateDayInt = 0 + (day - 30);
                }
            break;

            case 1:
                int moduloYear = year % 4;

                if (moduloYear == 0)
                    if (day >= 29){
                        startDateMonthInt = startDateMonthInt + 1;
                        startDateDayInt = 0 + (day - 29);
                    }
                    else if (day >= 28){
                        startDateMonthInt = startDateMonthInt + 1;
                        startDateDayInt = 0 + (day - 28);
                    }
            break;
        }
    }
}


