package com.example.alex_.hrcommunity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class AddEventsActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener, AdapterView.OnItemSelectedListener{

    //maakt globale variableen aan
    private TextView EventStartTijd, EventEindTijd, EventDatum;
    private EditText EventTitel;
    private Button BEventToevoegen, BEventStartijd, BEventEindTijd, BEventBeginDatum, gotoPeriodiek;
    private char begin;
    private int prioriteitLengte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_events);

        EventTitel = findViewById(R.id.textEventTitel);
        EventStartTijd = findViewById(R.id.textEventStartTijd);
        EventEindTijd= findViewById(R.id.textEventEindTijd);
        EventDatum = findViewById(R.id.textEventDatum);
        BEventToevoegen = findViewById(R.id.buttonEventToevoegen);
        BEventStartijd = findViewById(R.id.buttonEventStartTijd);
        BEventEindTijd = findViewById(R.id.buttonEventEindTijd);
        BEventBeginDatum = findViewById(R.id.buttonEventBeginDatum);
        gotoPeriodiek = findViewById(R.id.periodiekBtn);
        final Spinner prioriteitSpinner = findViewById(R.id.prioriteitSpinnerAdd);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.prioriteitArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        prioriteitSpinner.setAdapter(adapter);
        prioriteitSpinner.setOnItemSelectedListener(this);

        BEventToevoegen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                String titel = EventTitel.getText().toString();
                String starttijd = EventStartTijd.getText().toString();
                String eindtijd = EventEindTijd.getText().toString();
                String datum = EventDatum.getText().toString();
                int prioriteit = prioriteitLengte;

                if (titel.equals("") || starttijd.equals("") || eindtijd.equals("") || datum.equals("")) {
                    Toast.makeText(getApplicationContext(), "Kan niet toevoegen, niet alle velden zijn ingevuld", Toast.LENGTH_SHORT).show();
                }
                else{
                    Events events = new Events();
                    events.setTitel(titel);
                    events.setStart_tijd(starttijd);
                    events.setEind_tijd(eindtijd);
                    events.setDatum(datum);
                    //events.setPrioriteit(prioriteit);

                    //put data to database
                    MainActivity.myAppDatabase.myDao().addEvents(events);
                    EventTitel.setText("");
                    EventStartTijd.setText("");
                    EventEindTijd.setText("");
                    EventDatum.setText("");
                    prioriteitSpinner.setSelection(0);
                }
            }
        });

        gotoPeriodiek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddEventsActivity.this, Periodiek_Stap1.class);
                startActivity(intent);
            }
        });

        BEventStartijd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                begin = 'B';
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(),"time picker");
            }
        });

        BEventEindTijd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                begin = 'E';
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(),"time picker");
            }
        });

        BEventBeginDatum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

        String DateString = DateFormat.getDateInstance().format(c.getTime());
        TextView textView = (TextView) findViewById(R.id.textEventDatum);
        textView.setText(DateString);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        if (begin == 'B'){
            TextView textView = (TextView)findViewById(R.id.textEventStartTijd);
            textView.setText(hourOfDay + ":" + minute);
        }

        else{
            TextView textView = (TextView)findViewById(R.id.textEventEindTijd);
            textView.setText(hourOfDay + ":" + minute);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        parent.getItemAtPosition(position).toString();
        prioriteitLengte = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
