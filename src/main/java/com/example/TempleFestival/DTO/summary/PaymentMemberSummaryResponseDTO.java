package com.example.TempleFestival.DTO.summary;

import com.example.TempleFestival.DTO.response.PaymentResponseDTO;
import java.util.List;
public class PaymentMemberSummaryResponseDTO {
    


    private String memberName;
    private String festivalName;
    private String memberPhone;
    private int festivalYear;
    private List<PaymentResponseDTO> payments;
    private double totalPaid;
    
    public String getMemberName() {
        return memberName;
    }
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
    public String getFestivalName() {
        return festivalName;
    }
    public void setFestivalName(String festivalName) {
        this.festivalName = festivalName;
    }
    public String getMemberPhone() {
        return memberPhone;
    }
    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }
    public int getFestivalYear() {
        return festivalYear;
    }
    public void setFestivalYear(int festivalYear) {
        this.festivalYear = festivalYear;
    }
    public List<PaymentResponseDTO> getPayments() {
        return payments;
    }
    public void setPayments(List<PaymentResponseDTO> payments) {
        this.payments = payments;
    }
    public double getTotalPaid() {
        return totalPaid;
    }
    public void setTotalPaid(double totalPaid) {
        this.totalPaid = totalPaid;
    }

    

}
