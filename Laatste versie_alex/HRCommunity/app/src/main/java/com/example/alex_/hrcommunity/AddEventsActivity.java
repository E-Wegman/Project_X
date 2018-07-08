package com.example.alex_.hrcommunity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class AddEventsActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener{

    //maakt globale variableen aan
    private TextView EventStartTijd, EventEindTijd, EventDatum;
    private EditText EventTitel;
    private Button BEventToevoegen, BEventStartijd, BEventEindTijd, BEventBeginDatum;
    private char begin;



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

        BEventToevoegen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String titel = EventTitel.getText().toString();
                String starttijd = EventStartTijd.getText().toString();
                String eindtijd = EventEindTijd.getText().toString();
                String datum = EventDatum.getText().toString();

                if (titel.equals("") || starttijd.equals("") || eindtijd.equals("") || datum.equals("")) {
                    Toast.makeText(getApplicationContext(), "Kan niet toevoegen, niet alle velden zijn ingevuld", Toast.LENGTH_SHORT).show();
                }

                else{
                    Events events = new Events();
                    events.setTitel(titel);
                    events.setStart_tijd(starttijd);
                    events.setEind_tijd(eindtijd);
                    events.setDatum(datum);

                    //put data to database
                    MainActivity.myAppDatabase.myDao().addEvents(events);
                    EventTitel.setText("");
                    EventStartTijd.setText("");
                    EventEindTijd.setText("");
                    EventDatum.setText("");
                }
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
}
