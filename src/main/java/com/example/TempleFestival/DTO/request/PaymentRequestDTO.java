package com.example.TempleFestival.DTO.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class PaymentRequestDTO {
    
    @Positive (message = "Amount must be greater than zero")
     private double amount;

    @NotNull (message = "Payment date is required")
     private LocalDate paymentDate;

     @NotNull (message = "Member ID is required")
     @Positive (message = "Member Id must be greater than zero" )
     private int memberId;

     @NotNull (message = "Festiva ID is required")
     @Positive (message = "Festival Id must be greater than zero" )
     private int festivalId;
     
     
     public double getAmount() {
         return amount;
     }
     public void setAmount(double amount) {
         this.amount = amount;
     }
     public LocalDate getPaymentDate() {
         return paymentDate;
     }
     public void setPaymentDate(LocalDate paymentDate) {
         this.paymentDate = paymentDate;
     }
     public int getMemberId() {
         return memberId;
     }
     public void setMemberId(int memberId) {
         this.memberId = memberId;
     }
     public int getFestivalId() {
         return festivalId;
     }
     public void setFestivalId(int festivalId) {
         this.festivalId = festivalId;
     }

}
