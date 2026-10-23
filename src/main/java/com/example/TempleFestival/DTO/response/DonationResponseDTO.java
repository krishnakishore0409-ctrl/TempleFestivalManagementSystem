package com.example.TempleFestival.DTO.response;
   import java.time.LocalDate;

public class DonationResponseDTO {

     private int donationId;
     private LocalDate donationDate;
     private double value;
     private String itemName;
    
    public int getDonationId() {
        return donationId;
    }
    public void setDonationId(int donationId) {
        this.donationId = donationId;
    }
    public LocalDate getDonationDate() {
        return donationDate;
    }
    public void setDonationDate(LocalDate donationDate) {
        this.donationDate = donationDate;
    }
    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }
    
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    

    
}