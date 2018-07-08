package com.example.alex_.hrcommunity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
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

        private char begin = 'B';
        private String startTimeView, endTimeView, firstVacationDateString, fromStap1_5, datum, samenvoegingTitel;
        private int vacationLength, dagVanDeWeekInt, periodeLengte, startDateYearInt, startDateMonthInt, startDateDayInt, prioriteitLengte, dagInt, maandInt, jaarInt;
        private EditText vakNaamTextView, lokaalNaamTextView;
        private boolean weekToegevoegd;

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
            vakNaamTextView = findViewById(R.id.vakNaam);
            lokaalNaamTextView = findViewById(R.id.lokaalNaamText);

            Button beginTijd = (Button) findViewById(R.id.startTijdVerander);
            Button eindTijd = (Button) findViewById(R.id.eindTijdVerander);
            Button voegToe = (Button) findViewById(R.id.periodeToevoegenButton);

            Spinner weekDag = (Spinner) findViewById(R.id.weekDag);
            //Array adapter, haalt het op uit: res ->values->strings.xml
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.daysArray, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            weekDag.setAdapter(adapter);
            weekDag.setOnItemSelectedListener(new weekdagSpinnerClass());

            Spinner prioriteitSpinner = findViewById(R.id.prioriteitPeriodiek);
            ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.prioriteitArray, android.R.layout.simple_spinner_item);
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            prioriteitSpinner.setAdapter(adapter2);
            prioriteitSpinner.setOnItemSelectedListener(new PrioriteitSpinnerClass());

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
                String vakNaamText = vakNaamTextView.getText().toString();
                String lokaalNaamText = lokaalNaamTextView.getText().toString();
                samenvoegingTitel = vakNaamText + " - " + lokaalNaamText;

                if (vakNaamText.equals("") || lokaalNaamText.equals("") || startTimeView.equals("") || endTimeView.equals("")){
                  Toast.makeText(getApplicationContext(), "Vul de dagen in", Toast.LENGTH_SHORT).show();
                }
                else{
                  toevoegen();
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public class PrioriteitSpinnerClass implements AdapterView.OnItemSelectedListener{


        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            prioriteitLengte = position;
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    public class weekdagSpinnerClass implements AdapterView.OnItemSelectedListener{


        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            dagVanDeWeekInt = position;
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
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
        dagInt = startDateDayInt;
        maandInt = startDateMonthInt;
        jaarInt = startDateYearInt;
        weekToegevoegd = false;
        for (int i = 0; i < periodeLengte + 4; i++){
            switch (dagVanDeWeekInt){
                case 0:
                    if (weekToegevoegd == false){
                        weekToegevoegd = true;
                    }
                    else{
                        dagInt = dagInt + 7;
                    }
                    periodeToevoegen();
                    //its monday
                    break;

                case 1:
                    if (weekToegevoegd == false){
                        dagInt = dagInt + 1;
                        weekToegevoegd = true;
                    }
                    else{
                        dagInt = dagInt + 7;
                    }
                    //its tuesday
                    break;

                case 2:
                    if (weekToegevoegd == false){
                        dagInt = dagInt + 2;
                        weekToegevoegd = true;
                    }
                    else{
                        dagInt = dagInt + 7;
                    }
                    //its wednesday
                    break;

                case 3:
                    if (weekToegevoegd == false){
                        dagInt = dagInt + 3;
                        weekToegevoegd = true;
                    }
                    else{
                        dagInt = dagInt + 7;
                    }
                    //its thursday
                    break;

                case 4:
                    if (weekToegevoegd == false){
                        dagInt = dagInt + 4;
                        weekToegevoegd = true;
                    }
                    else{
                        dagInt = dagInt + 7;
                    }
                    // its friday
                    break;
            }
        }
    }

    private void periodeToevoegen() {
        Calendar c;
        monthChoose();

        c = Calendar.getInstance();
        c.set(Calendar.YEAR, jaarInt);
        c.set(Calendar.MONTH, maandInt);
        c.set(Calendar.DAY_OF_MONTH, dagInt);

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

    public void monthChoose(){
        switch (maandInt){
            case 0:
            case 2:
            case 4:
            case 6:
            case 7:
            case 9:
                if (dagInt >= 31){
                    dagInt = dagInt - 31;
                    maandInt = maandInt + 1;
                }
                break;

            case 11:
                if (dagInt >= 31){
                    startDateDayInt = startDateDayInt - 31;
                    startDateYearInt = startDateYearInt + 1;
                    startDateMonthInt = startDateMonthInt + 1;
                    }
            break;

            case 3:
            case 5:
            case 8:
            case 10:
                if (dagInt >= 30){
                    dagInt = dagInt - 30;
                    maandInt = maandInt + 1;
                }
                break;

            case 1:
                int moduloYear = jaarInt % 4;
                if (moduloYear == 0) {
                    if (dagInt >= 29) {
                        startDateDayInt = startDateDayInt - 29;
                        startDateMonthInt = startDateMonthInt + 1;
                    }
                }
                else if (dagInt >= 28) {
                    startDateDayInt = 0 + startDateDayInt - 28;
                    startDateMonthInt = startDateMonthInt + 1;
                    }

                break;
        }
    }
}


