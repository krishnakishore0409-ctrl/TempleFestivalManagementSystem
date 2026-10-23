package com.example.TempleFestival.DTO.summary;

public class FestivalInfoResponseDTO {
 
    
    private int festivalId;
    private String festivalName;
    private int festivalYear;
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
        return festivalYear;
    }
    public void setFestivalYear(int festivalYear) {
        this.festivalYear = festivalYear;
    }

    
}
