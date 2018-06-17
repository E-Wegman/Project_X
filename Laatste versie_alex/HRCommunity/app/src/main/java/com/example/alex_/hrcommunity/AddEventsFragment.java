package com.example.alex_.hrcommunity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddEventsFragment extends Fragment {

    private EditText Titel, Starttijd, Eindtijd, Datum;
    private Button toevoegen;

    public AddEventsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_events, container, false);

        Titel = view.findViewById(R.id.titel);
        Starttijd = view.findViewById(R.id.start_tijd);
        Eindtijd = view.findViewById(R.id.eind_tijd);
        Datum = view.findViewById(R.id.datum);
        toevoegen = view.findViewById(R.id.toevoegen);

        toevoegen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String titel = Titel.getText().toString();
                String starttijd = Starttijd.getText().toString();
                String eindtijd = Eindtijd.getText().toString();
                String datum = Datum.getText().toString();

                Events events = new Events();
                events.setTitel(titel);
                events.setStart_tijd(starttijd);
                events.setEind_tijd(eindtijd);
                events.setDatum(datum);

                //put data to database
                MainActivity.myAppDatabase.myDao().addEvents(events);
                Toast.makeText(getActivity(), "Events add succesfully",Toast.LENGTH_SHORT).show();

                Titel.setText("");
                Starttijd.setText("");
                Eindtijd.setText("");
                Datum.setText("");
            }
        });
        return view;
    }

}
