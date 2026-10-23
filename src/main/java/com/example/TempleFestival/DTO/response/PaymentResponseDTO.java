package com.example.TempleFestival.DTO.response;

import java.time.LocalDate;

public class PaymentResponseDTO {
    
    private int paymentId;
    private double amount;
    private LocalDate paymentDate;
    
    public int getPaymentId() {
        return paymentId;
    }
    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }
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
   

    
}
