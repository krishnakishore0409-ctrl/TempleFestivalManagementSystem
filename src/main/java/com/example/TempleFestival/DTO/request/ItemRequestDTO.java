package com.example.TempleFestival.DTO.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ItemRequestDTO {
    
   @NotBlank (message = "Item name is required")
    private String itemName;

    @NotNull (message = "Unit Id is required")
    @Positive (message = "Unit Id must be greater than zero")
    private int unitId;

    @NotNull (message = "Donation type Id is required")
    @Positive (message = "Donation type Id must be greater than zero")
    private int donationTypeId;
    

    
    public String getItemName() {
        return itemName;
    }
    
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public int getDonationTypeId() {
        return donationTypeId;
    }

    public void setDonationTypeId(int donationTypeId) {
        this.donationTypeId = donationTypeId;
    }

    
}
