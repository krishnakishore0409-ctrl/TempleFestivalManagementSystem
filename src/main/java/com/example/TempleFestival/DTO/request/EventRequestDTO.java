package com.example.TempleFestival.DTO.request;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

public class EventRequestDTO {
    
    
    @NotBlank (message = "Event name is required")
    private String eventName;

    @NotNull (message = "Event date is required")
    private LocalDate eventDate;

     @NotNull (message = "Event time is required")
    private LocalTime eventTime;

    @NotBlank(message = "Description is required")
    private String description;

    @NotBlank (message = "Session is required")
    private String session;

    @Positive(message = "Day number must be greater than zero")
    @Min(value = 1,message = "Day number must be at least 1")
    @Max(value = 10,message = "Day number cannot exceed 10")
    private int dayNo;

    @NotNull (message = "Festival ID is required")
    @Positive (message = "Festival Id must be greater than zero")
    private int FestivalId;
    
   
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
    public LocalTime getEvenTime() {
        return eventTime;
    }
    public void setEvenTime(LocalTime evenTime) {
        this.eventTime = evenTime;
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
    public int getFestivalId() {
        return FestivalId;
    }
    public void setFestivalId(int festivalId) {
        FestivalId = festivalId;
    }
    
}
