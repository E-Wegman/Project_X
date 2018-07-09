package com.example.alex_.hrcommunity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EvenementenAdapter extends RecyclerView.Adapter<EvenementenAdapter.EvenementenViewHolder> {
    public ArrayList<EvenementenReader> mEvenementenReaders;


    public class EvenementenViewHolder extends RecyclerView.ViewHolder {
        public ArrayList<EvenementenReader> mEvenementenReaders;
        public TextView mTitelView;
        public TextView mBeginTijdView;
        public TextView mEindTijdView;
        public TextView mDatumView;
        public TextView mPrioriteitView;

        public Events ClickedOne;

        public EvenementenViewHolder(final View itemView) {
            super(itemView);
            mTitelView = itemView.findViewById(R.id.titelEvenement);
            mBeginTijdView = itemView.findViewById(R.id.beginTijdEvenement);
            mEindTijdView = itemView.findViewById(R.id.eindTijdEvenement);
            mDatumView = itemView.findViewById(R.id.datumEvenement);
            mPrioriteitView = itemView.findViewById(R.id.PrioriteitView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(itemView.getContext(), VeranderActivity.class);
                        int EventID;

                    //get the one you clicked
                    getAdapterPosition();
                    if (getAdapterPosition() < 1) {
                        EventID = getEvenements().get(0).getIDEvenement();
                    }
                    else if (getAdapterPosition() < 2){
                        EventID = getEvenements().get(1).getIDEvenement();
                    }
                    else if (getAdapterPosition() < 3){
                        EventID = getEvenements().get(2).getIDEvenement();
                    }
                    else if (getAdapterPosition() < 4){
                        EventID = getEvenements().get(3).getIDEvenement();
                    }
                    else if (getAdapterPosition() < 5){
                        EventID = getEvenements().get(4).getIDEvenement();
                    }
                    else if (getAdapterPosition() < 6){
                        EventID = getEvenements().get(5).getIDEvenement();
                    }
                    else if (getAdapterPosition() < 7){
                        EventID = getEvenements().get(6).getIDEvenement();
                    }
                    else if (getAdapterPosition() < 8){
                        EventID = getEvenements().get(7).getIDEvenement();
                    }
                    else if (getAdapterPosition() < 9){
                        EventID = getEvenements().get(8).getIDEvenement();
                    }
                    else if (getAdapterPosition() < 10){
                        EventID = getEvenements().get(9).getIDEvenement();
                    }
                    else{
                        EventID = getEvenements().get(10).getIDEvenement();
                    }

                    intent.putExtra("ID", EventID);
                    itemView.getContext().startActivity(intent);

                }
            });
        }
    }

    public EvenementenAdapter(ArrayList<EvenementenReader> evenementenReaderList) {
        mEvenementenReaders = evenementenReaderList;
    }

    @NonNull
    @Override
    public EvenementenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false);
        EvenementenViewHolder evh = new EvenementenViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull EvenementenViewHolder holder, int position) {
        EvenementenReader currentReader = mEvenementenReaders.get(position);

        //Sets priority to a string
        int prioriteit = currentReader.getPrioriteit();
        String Sprioriteit = "" + prioriteit;

        holder.mTitelView.setText(currentReader.gettitelEvenement());
        holder.mBeginTijdView.setText(currentReader.getbeginTijdEvenement());
        holder.mEindTijdView.setText(currentReader.geteindTijdEvenement());
        holder.mDatumView.setText(currentReader.getdatumEvenement());
        holder.mPrioriteitView.setText(Sprioriteit);

    }

    @Override
    public int getItemCount() {
        return mEvenementenReaders.size();
    }

    public ArrayList<EvenementenReader> getEvenements() { return mEvenementenReaders; }

}


