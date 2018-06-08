package com.example.alex_.hrcommunity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EventActivity extends AppCompatActivity {

    private static final String TAG = "CalendarActivity";

    database mDatabaseHelper;
    EditText activiteit;
    TextView date;
    Button toevoegen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_layout);
        activiteit =  findViewById(R.id.activiteit);
        date =  findViewById(R.id.date);
        toevoegen = findViewById(R.id.toevoegen);
        mDatabaseHelper = new database(this);

        toevoegen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {EditText.getText().toString();
                String newEntry =

                Intent intent = new Intent(EventActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
    public void AddData(String newEntry){
        boolean insertData = mDatabaseHelper.addData(newEntry);

        if(insertData){
            toastMessage("Data is opgeslagen!");
        }else{
            toastMessage("Data is niet opgeslagen!");
        }
    }

    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}