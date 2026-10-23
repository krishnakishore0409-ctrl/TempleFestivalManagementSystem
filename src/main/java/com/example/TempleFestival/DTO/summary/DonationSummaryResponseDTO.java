package com.example.TempleFestival.DTO.summary;

import java.util.Map;

public class DonationSummaryResponseDTO {
    
    private double cashDonation;

    private Map<String,MaterialDonationResponseDTO> materialDonations;

    public double getCashDonation() {
        return cashDonation;
    }

    public void setCashDonation(double cashDonation) {
        this.cashDonation = cashDonation;
    }

    public Map<String,MaterialDonationResponseDTO> getMaterialDonations() {
        return materialDonations;
    }

    public void setMaterialDonations(Map<String,MaterialDonationResponseDTO> materialDonations) {
        this.materialDonations = materialDonations;
    }

}
