package com.example.TempleFestival.DTO.summary;

import java.util.List;
public class DonationFestivalSummaryResponseDTO {
    
    private String festivalName;
    private int year;
    private List<DonationMemberSummaryResponseDTO> members;
    
    public String getFestivalName() {
        return festivalName;
    }
    public void setFestivalName(String festivalName) {
        this.festivalName = festivalName;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public List<DonationMemberSummaryResponseDTO> getMembers() {
        
        return members;
    }
    public void setMembers(List<DonationMemberSummaryResponseDTO> members) {
        this.members = members;
    }
    
}
