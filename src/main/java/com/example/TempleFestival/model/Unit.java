package com.example.TempleFestival.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;

@Entity
public class Unit{
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int unitId;

    private String unitName;

    @OneToMany(mappedBy = "unit")
    private List<Item> item;
 
    @OneToMany(mappedBy = "unit")
    private List<Expense> expense;

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    

}