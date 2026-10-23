package com.example.TempleFestival.DTO.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class FestivalRequestDTO {
    
  
    @NotBlank (message = "Festival name is required")
    private String festivalName;

    @Min(value = 2000, message = "Year must be valid")
    private int year;

    @NotNull (message = "Start_date is required")
    private LocalDate start_Date;

    @NotNull (message = "Ent_Date is required")
    private LocalDate end_Date;

    
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
