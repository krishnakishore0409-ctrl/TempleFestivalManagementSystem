package com.example.TempleFestival.model;
import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;


@Entity
public class Payment{

    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int paymentId;
     private double amount;
     private LocalDate paymentDate;
     

     @ManyToOne
     @JoinColumn(name = "member_id")
     private Member member;

     @ManyToOne
     @JoinColumn(name = "festival_id")
     private Festival festival;

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

     public Member getMember() {
       return member;
     }

     public void setMember(Member member) {
       this.member = member;
     }

     public Festival getFestival() {
       return festival;
     }

     public void setFestival(Festival festival) {
       this.festival = festival;
     }


 
}