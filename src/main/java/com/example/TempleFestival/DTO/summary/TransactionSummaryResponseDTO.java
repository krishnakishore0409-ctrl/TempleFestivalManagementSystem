package com.example.TempleFestival.DTO.summary;

public class TransactionSummaryResponseDTO {
 
    
    private long totalMembers;
    private long totalPaymentTransactions;
    private long totalDonationTransactions;
    private long totalExpenseTransactions;
    public long getTotalMembers() {
        return totalMembers;
    }
    public void setTotalMembers(long totalMembers) {
        this.totalMembers = totalMembers;
    }
    public long getTotalPaymentTransactions() {
        return totalPaymentTransactions;
    }
    public void setTotalPaymentTransactions(long totalPaymentTransactions) {
        this.totalPaymentTransactions = totalPaymentTransactions;
    }
    public long getTotalDonationTransactions() {
        return totalDonationTransactions;
    }
    public void setTotalDonationTransactions(long totalDonationTransactions) {
        this.totalDonationTransactions = totalDonationTransactions;
    }
    public long getTotalExpenseTransactions() {
        return totalExpenseTransactions;
    }
    public void setTotalExpenseTransactions(long totalExpenseTransactions) {
        this.totalExpenseTransactions = totalExpenseTransactions;
    }
    
}
