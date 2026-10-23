package com.example.TempleFestival.DTO.response;

import java.time.LocalDate;

public class ExpenseResponseDTO {
    private int expenseId;
   private String expenseName;
   private double totalAmount;
   private LocalDate purchaseDate;
   private int quantity;
   private double unitPrice;
   private String expenseTypeName;
   private String unitName;
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
  
   public String getExpenseTypeName() {
    return expenseTypeName;
   }
   public void setExpenseTypeName(String expenseTypeName) {
    this.expenseTypeName = expenseTypeName;
   }
   public String getUnitName() {
    return unitName;
   }
   public void setUnitName(String unitName) {
    this.unitName = unitName;
   }

   
}
