package com.example.alex_.hrcommunity;
import android.arch.persistence.room.*;
import android.graphics.Bitmap;

//The Table
@Entity
public class Activity {
    @PrimaryKey(autoGenerate = true)
    private int aid;

    private String activityName;
    private String activityEvent; //school/private/work
    private String Colour;
    private int priority;
    @Embedded
    public Date date;
    private boolean periodic;

    //Getters and setters
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
    public Date getDate() { return date; }
    public void setDate(Date date) {
        this.date = date;
    }
    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
    public boolean isPeriodic() { return periodic; }
    public void setPeriodic(boolean periodic) { this.periodic = periodic; }
    public Bitmap getPicture() {
        return picture;
    }
    public void setPicture(Bitmap picture) {
        this.picture = picture;
    }

    //The start and end Date of the item
    public static class Date {
        public int startYear;
        public int startMonth;
        public int startDay;
        public int startHours;
        public int startMinutes;

        public int endYear;
        public int endMonth;
        public int endDay;
        public int endHours;
        public int endMinutes;

        //Their getters and setters
        public int getStartYear() {
            return startYear;
        }
        public void setStartYear(int startYear) { this.startYear = startYear; }
        public int getStartMonth() {
            return startMonth;
        }
        public void setStartMonth(int startMonth) { this.startMonth = startMonth; }
        public int getStartDay() {
            return startDay;
        }
        public void setStartDay(int startDay) {
            this.startDay = startDay;
        }
        public int getStartHours() { return startHours; }
        public void setStartHours(int startHours) { this.startHours = startHours; }
        public int getStartMinutes() { return startMinutes; }
        public void setStartMinutes(int startMinutes) { this.startMinutes = startMinutes; }

        public int getEndYear() {
            return endYear;
        }
        public void setEndYear(int endYear) {
            this.endYear = endYear;
        }
        public int getEndMonth() {
            return endMonth;
        }
        public void setEndMonth(int endMonth) {
            this.endMonth = endMonth;
        }
        public int getEndDay() {
            return endDay;
        }
        public void setEndDay(int endDay) {
            this.endDay = endDay;
        }
        public int getEndHours() { return endHours; }
        public void setEndHours(int endHours) { this.endHours = endHours; }
        public int getEndMinutes() { return endMinutes; }
        public void setEndMinutes(int endMinutes) { this.endMinutes = endMinutes; }
    }

    @Ignore
    Bitmap picture;
}

