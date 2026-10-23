package com.example.TempleFestival.DTO.response;

import java.time.LocalDate;
import java.time.LocalTime;

public class EventResponseDTO {
    

    private int eventId;
    private String eventName;
    private LocalDate eventDate;
    private LocalTime eventTime;
    private String description;
    private String session;
    private int dayNo;
    private String festivalName;
    private int year;
    public int getEventId() {
        return eventId;
    }
    public void setEventId(int eventId) {
        this.eventId = eventId;
    }
    public String getEventName() {
        return eventName;
    }
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    public LocalDate getEventDate() {
        return eventDate;
    }
    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }
    public LocalTime getEventTime() {
        return eventTime;
    }
    public void setEventTime(LocalTime eventTime) {
        this.eventTime = eventTime;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getSession() {
        return session;
    }
    public void setSession(String session) {
        this.session = session;
    }
    public int getDayNo() {
        return dayNo;
    }
    public void setDayNo(int dayNo) {
        this.dayNo = dayNo;
    }
    public String getFestivalName() {
        return festivalName;
    }
    public void setFestivalName(String festivalName) {
        this.festivalName = festivalName;
    }
    public int getFestivalYear() {
        return year;
    }
    public void setFestivalYear(int year) {
        this.year = year;
    }


    
}
