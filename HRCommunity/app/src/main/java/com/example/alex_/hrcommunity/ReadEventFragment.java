package com.example.alex_.hrcommunity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadEventFragment extends Fragment {

    private TextView EventInfo;

    public ReadEventFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read_event, container, false);
        //read database
        EventInfo = view.findViewById(R.id.display_event);
        List<Events> events = MainActivity.myAppDatabase.myDao().getEvents();

        String info = "";

        for(Events evts: events){
            String titel = evts.getTitel();
            String start_tijd = evts.getStart_tijd();
            String eind_tijd = evts.getEind_tijd();
            String datum = evts.getDatum();

            info = info+"\n\n"+"Titel : "+titel+"\n Start tijd :"+start_tijd+"\n Eind tijd : "+eind_tijd+"\n Datum :"+datum;
        }

        EventInfo.setText(info);
        return view;
    }

}
