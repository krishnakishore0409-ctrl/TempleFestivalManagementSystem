package com.example.TempleFestival.DTO.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ExpenseRequestDTO {
    
   
   @NotBlank (message = "Expense name is required")
   private String expenseName;

   private double totalAmount;

   @NotEmpty (message = "Purchase date is required")
   private LocalDate purchaseDate;

   @Positive (message = "Quantity must be greater than zero")
   private int quantity;

   @Positive (message = "Unit price must be greater than zero")
   private double unitPrice;

   @NotNull (message = "Festival ID is required")
   @Positive (message = "Festival Id must be greater than zero")
   private int festivalId;

   @NotNull (message = "Event ID is required")
   @Positive (message = "Event Id must be greater than zero")
   private int eventId;

   @NotNull (message = "Expense type ID is required")
   @Positive (message = "Expense type Id must be greater than zero")
   private int  expenseTypeId;

   @NotNull (message = "Unit ID is required")
   @Positive (message = "Unit Id must be greater than zero")
   private int unitId;
   
   public String getExpenseName(){
    return expenseName;
   }
   
   public void setExpenseName(String expenseName) {
    this.expenseName = expenseName;
   }
   public double getTotalAmount() {
    return totalAmount;
   }
   public void setTotalAmount(double totalAmount) {
    this.totalAmount = totalAmount;
   }
   public LocalDate getPurchaseDate() {
    return purchaseDate;
   }
   public void setPurchaseDate(LocalDate purchaseDate) {
    this.purchaseDate = purchaseDate;
   }
   public int getQuantity() {
    return quantity;
   }
   public void setQuantity(int quantity) {
    this.quantity = quantity;
   }
   public double getUnitPrice() {
    return unitPrice;
   }
   public void setUnitPrice(double unitPrice) {
    this.unitPrice = unitPrice;
   }
   public int getFestivalId() {
    return festivalId;
   }
   public void setFestivalId(int festivalId) {
    this.festivalId = festivalId;
   }
   public int getEventId() {
    return eventId;
   }
   public void setEventId(int eventId) {
    this.eventId = eventId;
   }
   public int getExpenseTypeId() {
    return expenseTypeId;
   }
   public void setExpenseTypeId(int expenseTypeId) {
    this.expenseTypeId = expenseTypeId;
   }
   public int getUnitId() {
    return unitId;
   }
   public void setUnitId(int unitId) {
    this.unitId = unitId;
   }



}
