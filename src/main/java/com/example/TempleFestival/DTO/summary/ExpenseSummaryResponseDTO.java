package com.example.TempleFestival.DTO.summary;

import com.example.TempleFestival.DTO.response.ExpenseResponseDTO;

import java.util.List;
public class ExpenseSummaryResponseDTO {
    
    private String eventName;
    private String festivalName;
    private int year;
    private List<ExpenseResponseDTO> expenses;
    private double eventTotalAmount;
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getFestivalName() {
		return festivalName;
	}
	public void setFestivalName(String festivalName) {
		this.festivalName = festivalName;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public List<ExpenseResponseDTO> getExpenses() {
		return expenses;
	}
	public void setExpenses(List<ExpenseResponseDTO> expenses) {
		this.expenses = expenses;
	}
	public double getEventTotalAmount() {
		return eventTotalAmount;
	}
	public void setEventTotalAmount(double eventTotalAmount) {
		this.eventTotalAmount = eventTotalAmount;
	}


}
