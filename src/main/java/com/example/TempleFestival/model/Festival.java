package com.example.TempleFestival.model;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import java.util.*;

@Entity
public class Festival{

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int festivalId;
    
    private String festivalName;
    private int year;
    private LocalDate start_Date;
    private LocalDate end_Date;
    
    @OneToMany(mappedBy = "festival")
    private List<Donation> donation;

    @OneToMany(mappedBy = "festival")
    private List<Payment> payment;

    @OneToMany(mappedBy = "festival")
    private List<Expense> expense;

    @OneToMany(mappedBy = "festival")
    private List<Event> event;

    @OneToMany(mappedBy = "festival")
    private List<CommitteeMember> committeeMember;

    public int getFestivalId() {
        return festivalId;
    }

    public void setFestivalId(int festivalId) {
        this.festivalId = festivalId;
    }

    public String getFestivalName() {
        return festivalName;
    }

    public void setFestivalName(String festivalName) {
        this.festivalName = festivalName;
    }

    public int getFestivalYear() {
        return year;
    }

    public void setFestivalYear(int year) {
        this.year = year;
    }

    public LocalDate getFestivalStart_Date() {
        return start_Date;
    }

    public void setFestivalStart_Date(LocalDate start_Date) {
        this.start_Date = start_Date;
    }

    public LocalDate getFestivalEnd_Date() {
        return end_Date;
    }

    public void setFestivalEnd_Date(LocalDate end_Date) {
        this.end_Date = end_Date;
    }


    
   }



