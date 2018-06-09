package com.example.alex_.hrcommunity;

import android.arch.persistence.room.*;
import android.graphics.Bitmap;
//Dit is de table

@Entity
public class Activity {
    @PrimaryKey // id
    private int aid;

    private String activityName;

    private String activityEvent; //school/prive/werk

    private String Colour;

    private int priority;

    @Embedded
    public Date date;


    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityEvent() {
        return activityEvent;
    }

    public void setActivityEvent(String activityEvent) {
        this.activityEvent = activityEvent;
    }

    public String getColour() {
        return Colour;
    }

    public void setColour(String colour) {
        Colour = colour;
    }

    public Date getDate() {

        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int prority) {
        this.priority = prority;
    }

    public Bitmap getPicture() {
        return picture;
    }

    public void setPicture(Bitmap picture) {
        this.picture = picture;
    }

    public static class Date {
        public String startYear;
        public String startMonth;
        public String startDay;
        public String startHours_Minutes;

        public String endYear;
        public String endMonth;
        public String endDay;
        public String endHours_Minutes;

        public String getStartYear() {
            return startYear;
        }

        public void setStartYear(String startyear) {
            this.startYear = startYear;
        }

        public String getStartMonth() {
            return startMonth;
        }

        public void setStartMonth(String startMonth) {
            this.startMonth = startMonth;
        }

        public String getStartday() {
            return startDay;
        }

        public void setStartDay(String startDay) {
            this.startDay = startDay;
        }

        public String getStartHours_Minutes() {
            return startHours_Minutes;
        }

        public void setStartHours_Minutes(String startHours_Minutes) {
            this.startHours_Minutes = startHours_Minutes;
        }

        public String getEndYear() {
            return endYear;
        }

        public void setEndYear(String endYear) {
            this.endYear = endYear;
        }

        public String getEndMonth() {
            return endMonth;
        }

        public void setEndMonth(String endMonth) {
            this.endMonth = endMonth;
        }

        public String getEndDay() {
            return endDay;
        }

        public void setEndDay(String endDay) {
            this.endDay = endDay;
        }

        public String getEndHours_Minutes() {
            return endHours_Minutes;
        }

        public void setEndHours_Minutes(String endhours_minutes) {
            this.endHours_Minutes = endhours_minutes;
        }
    }

    @Ignore
    Bitmap picture;
}

