package com.example.TempleFestival.DTO.response;

import java.time.LocalDate;

public class FestivalResponseDTO {
 
    private int festivalId;
    
    private String festivalName;
    private int year;
    private LocalDate start_Date;
    private LocalDate end_Date;
    public int getFestivalId() {
        return festivalId;
    }
    public void setFestivalId(int festivalId) {
        this.festivalId = festivalId;
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
    public LocalDate getFestivalStart_Date() {
        return start_Date;
    }
    public void setFestivalStart_Date(LocalDate start_Date) {
        this.start_Date = start_Date;
    }
    public LocalDate getFestivalEnd_Date() {
        return end_Date;
    }
    public void setFestivalEnd_Date(LocalDate end_Date) {
        this.end_Date = end_Date;
    }
}
