package com.example.TempleFestival.DTO.response;

public class DonationTypeResponseDTO {
    
    private int donationTypeId;
    private String donationTypeName;
    
    public int getDonationTypeId() {
        return donationTypeId;
    }
    public void setDonationTypeId(int donationTypeId) {
        this.donationTypeId = donationTypeId;
    }
    public String getDonationTypeName() {
        return donationTypeName;
    }
    public void setDonationTypeName(String donationTypeName) {
        this.donationTypeName = donationTypeName;
    }
}
