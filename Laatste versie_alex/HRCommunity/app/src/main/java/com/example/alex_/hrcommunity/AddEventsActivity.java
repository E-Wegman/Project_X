package com.example.alex_.hrcommunity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.Calendar;

public class AddEventsActivity extends AppCompatActivity implements  DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    private TextView EventStartTijd, EventEindTijd, EventDatum;
    private EditText EEventTitel;
    private Button BEventToevoegen, BEventStartijd, BEventEindTijd, BEventBeginDatum;
    private char begin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //koppelt de globale variableen aan de gegevens van de ID's in het xml bestand
        EEventTitel = findViewById(R.id.textEventTitel);
        EventStartTijd = findViewById(R.id.textEventStartTijd);
        EventEindTijd = findViewById(R.id.textEventEindTijd);
        EventDatum = findViewById(R.id.textEventDatum);
        BEventToevoegen = findViewById(R.id.buttonEventToevoegen);
        BEventStartijd = findViewById(R.id.buttonEventStartTijd);
        BEventEindTijd = findViewById(R.id.buttonEventEindTijd);
        BEventBeginDatum = findViewById(R.id.buttonEventBeginDatum);

        //
        BEventToevoegen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titel = EEventTitel.getText().toString();
                String starttijd = EventStartTijd.getText().toString();
                String eindtijd = EventEindTijd.getText().toString();
                String datum = EventDatum.getText().toString();

                Events events = new Events();
                events.setTitel(titel);
                events.setStart_tijd(starttijd);
                events.setEind_tijd(eindtijd);
                events.setDatum(datum);

                //put data to database
                MainActivity.myAppDatabase.myDao().addEvents(events);
                EEventTitel.setText("");
                EventStartTijd.setText("");
                EventEindTijd.setText("");
                EventDatum.setText("");
            }
        });


        BEventBeginDatum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        BEventStartijd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                begin = 'B';
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");
            }
        });

        BEventEindTijd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                begin = 'E';
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        String DateString = DateFormat.getDateInstance().format(c.getTime());
        TextView textView = (TextView) view.findViewById(R.id.eindePeriode);
        textView.setText(DateString);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        TextView textView = view.findViewById(R.id.textEventStartTijd);
        textView.setText("Hour: " + hourOfDay + " Minute: " + minute );
    }
}