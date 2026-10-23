package com.example.TempleFestival.DTO.request;

import java.time.LocalDate;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


public class DonationRequestDTO{

     @NotNull(message = "Festival date is required")
    private LocalDate donationDate;

    @Positive (message = "Donation value must be greater than zero")
    private double value;

    @NotNull(message = "Festival ID is required")
    @Positive (message = "Festival Id must be greater than zero")
    private int  festivalId;

    @NotNull(message = "Member ID is required")
    @Positive (message = "Member Id must be greater than zero")
    private int memberId;

    @NotNull(message = "Item ID is required")
    @Positive (message = "Item Id must be greater than zero")
    private int itemId;
    
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
    public int getFestivalId() {
        return festivalId;
    }
    public void setFestivalId(int festivalId) {
        this.festivalId = festivalId;
    }
    public int getMemberId() {
        return memberId;
    }
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }
    public int getItemId() {
        return itemId;
    }
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    
}