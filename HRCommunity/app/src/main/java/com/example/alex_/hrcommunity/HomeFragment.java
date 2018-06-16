package com.example.alex_.hrcommunity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private Button addBtn, viewBtn;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        addBtn = view.findViewById(R.id.addBtn);
        addBtn.setOnClickListener(this);

        viewBtn = view.findViewById(R.id.viewBtn);
        viewBtn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.addBtn:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new AddEventsFragment()).
                        addToBackStack(null).commit();
                break;

            case R.id.viewBtn:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new ReadEventFragment()).
                        addToBackStack(null).commit();
                break;
        }
    }
}
