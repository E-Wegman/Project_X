package com.example.alex_.hrcommunity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "event")
public class Events {

    @PrimaryKey(autoGenerate = true)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ColumnInfo(name = "titel")
    private String titel;

    @ColumnInfo(name = "start_tijd")
    private String start_tijd;

    @ColumnInfo(name = "eind_tijd")
    private String eind_tijd;

    @ColumnInfo(name = "datum")
    private String datum;

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getStart_tijd() {
        return start_tijd;
    }

    public void setStart_tijd(String start_tijd) {
        this.start_tijd = start_tijd;
    }

    public String getEind_tijd() {
        return eind_tijd;
    }

    public void setEind_tijd(String eind_tijd) {
        this.eind_tijd = eind_tijd;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }
}
