package com.example.TempleFestival.model;
import java.util.List;

import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Entity;

@Entity
public class Item{

    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;
    
    private String itemName;
    
    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;


    @ManyToOne 
    @JoinColumn(name = "donation_type_id")
    private DonationType donationType;


    @OneToMany(mappedBy = "item")
     private List<Donation> donation;


    public int getItemId() {
        return itemId;
    }

    
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public DonationType getDonationType() {
        return donationType;
    }

    public void setDonationType(DonationType donationType) {
        this.donationType = donationType;
    }

     
    
}