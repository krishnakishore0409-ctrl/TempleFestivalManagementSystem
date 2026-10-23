package com.example.TempleFestival.DTO.summary;

public class FinancialSummaryResponseDTO {
    
    private double totalPayments;
    private double totalCashDonations;
    private double totalIncome;
    private double totalExpense;
    private double balanceAmount;
    public double getTotalPayments() {
        return totalPayments;
    }
    public void setTotalPayments(double totalPayments) {
        this.totalPayments = totalPayments;
    }
    public double getTotalCashDonations() {
        return totalCashDonations;
    }
    public void setTotalCashDonations(double totalCashDonations) {
        this.totalCashDonations = totalCashDonations;
    }
    public double getTotalIncome() {
        return totalIncome;
    }
    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }
    public double getTotalExpense() {
        return totalExpense;
    }
    public void setTotalExpense(double totalExpense) {
        this.totalExpense = totalExpense;
    }
    public double getBalanceAmount() {
        return balanceAmount;
    }
    public void setBalanceAmount(double balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    
}
