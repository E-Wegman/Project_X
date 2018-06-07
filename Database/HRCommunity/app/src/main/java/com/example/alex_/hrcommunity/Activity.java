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

    public Date getStart() {

        return date;
    }

    public void setStart(Date start) {
        this.date = start;
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

        public String getStartyear() {
            return startYear;
        }

        public void setStartyear(String startyear) {
            this.startYear = startYear;
        }

        public String getStartmonth() {
            return startMonth;
        }

        public void setStartmonth(String startMonth) {
            this.startMonth = startMonth;
        }

        public String getStartday() {
            return startDay;
        }

        public void setStartday(String startDay) {
            this.startDay = startDay;
        }

        public String getStarthours_minutes() {
            return startHours_Minutes;
        }

        public void setStarthours_minutes(String startHours_Minutes) {
            this.startHours_Minutes = startHours_Minutes;
        }

        public String getEndyear() {
            return endYear;
        }

        public void setEndyear(String endYear) {
            this.endYear = endYear;
        }

        public String getEndmonth() {
            return endMonth;
        }

        public void setEndmonth(String endMonth) {
            this.endMonth = endMonth;
        }

        public String getEndday() {
            return endDay;
        }

        public void setEndday(String endDay) {
            this.endDay = endDay;
        }

        public String getEndhours_minutes() {
            return endHours_Minutes;
        }

        public void setEndhours_minutes(String endhours_minutes) {
            this.endHours_Minutes = endhours_minutes;
        }
    }

    @Ignore
    Bitmap picture;
}

