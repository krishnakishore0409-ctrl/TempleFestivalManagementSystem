package com.example.TempleFestival.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class Expense{

   @Id 
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int expenseId;

   private String expenseName;
   private double totalAmount;
   private LocalDate purchaseDate;
   private int quantity;
   private double unitPrice;

   @ManyToOne
   @JoinColumn(name = "festival_id")
   private Festival festival;

   @ManyToOne
   @JoinColumn(name = "event_id")
   private Event event;

   @ManyToOne
   @JoinColumn(name = "expense_type_id")
   private ExpenseType expenseType;

   @ManyToOne
   @JoinColumn(name = "unit_Id")
   private Unit unit;

   public int getExpenseId() {
      return expenseId;
   }

   public void setExpenseId(int expenseId) {
      this.expenseId = expenseId;
   }

   public String getExpenseName() {
      return expenseName;
   }

   public void setExpenseName(String expenseName) {
      this.expenseName = expenseName;
   }

   public double getExpenseTotalAmount() {
      return totalAmount;
   }

   public void setExpenseTotalAmount(double totalAmount) {
      this.totalAmount = totalAmount;
   }

   public LocalDate getExpensePurchaseDate() {
      return purchaseDate;
   }

   public void setExpensePurchaseDate(LocalDate purchaseDate) {
      this.purchaseDate = purchaseDate;
   }

   public int getExpenseQuantity() {
      return quantity;
   }

   public void setExpenseQuantity(int quantity) {
      this.quantity = quantity;
   }

   public double getExpenseUnitPrice() {
      return unitPrice;
   }

   public void setExpenseUnitPrice(double unitPrice) {
      this.unitPrice = unitPrice;
   }

   public Festival getFestival() {
      return festival;
   }

   public void setFestival(Festival festival) {
      this.festival = festival;
   }

   public Event getEvent() {
      return event;
   }

   public void setEvent(Event event) {
      this.event = event;
   }

   public ExpenseType getExpenseType() {
      return expenseType;
   }

   public void setExpenseType(ExpenseType expenseType) {
      this.expenseType = expenseType;
   }

   public Unit getUnit() {
      return unit;
   }

   public void setUnit(Unit unit) {
      this.unit = unit;
   }




}