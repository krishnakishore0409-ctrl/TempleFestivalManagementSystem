package com.example.TempleFestival.DTO.request;

import jakarta.validation.constraints.NotBlank;

public class DonationTypeRequestDTO {
    
    @NotBlank(message = "DonationType name is required")
    private String donationTypeName;
    
    public String getDonationTypeName() {
        return donationTypeName;
    }
    public void setDonationTypeName(String donationTypeName) {
        this.donationTypeName = donationTypeName;
    }

}
