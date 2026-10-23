package com.example.TempleFestival.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity

public class DonationType{
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int donationTypeId;

    private String donationTypeName;

    @OneToMany(mappedBy = "donationType")
    private List<Item> item;

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
