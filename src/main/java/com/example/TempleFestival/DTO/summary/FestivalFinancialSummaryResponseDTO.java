package  com.example.TempleFestival.DTO.summary;

public class FestivalFinancialSummaryResponseDTO {
    

    private FestivalInfoResponseDTO festival;
    private FinancialSummaryResponseDTO financialSummary;
    private DonationSummaryResponseDTO donationSummary;
    private TransactionSummaryResponseDTO transactionSummary;
    
    public FestivalInfoResponseDTO getFestival() {
        return festival;
    }
    public void setFestival(FestivalInfoResponseDTO festival) {
        this.festival = festival;
    }
    public FinancialSummaryResponseDTO getFinancialSummary() {
        return financialSummary;
    }
    public void setFinancialSummary(FinancialSummaryResponseDTO financialSummary) {
        this.financialSummary = financialSummary;
    }
    public DonationSummaryResponseDTO getDonationSummary() {
        return donationSummary;
    }
    public void setDonationSummary(DonationSummaryResponseDTO donationSummary) {
        this.donationSummary = donationSummary;
    }
    public TransactionSummaryResponseDTO getTransactionSummary() {
        return transactionSummary;
    }
    public void setTransactionSummary(TransactionSummaryResponseDTO transactionSummary) {
        this.transactionSummary = transactionSummary;
    }

    
}
