package com.example.TempleFestival.service;

import org.springframework.stereotype.Service;
import com.example.TempleFestival.repository.DonationRepository;
import com.example.TempleFestival.repository.ExpenseRepository;
import com.example.TempleFestival.repository.FestivalRepository;
import com.example.TempleFestival.repository.PaymentRepository;
import com.example.TempleFestival.DTO.summary.DonationSummaryResponseDTO;
import com.example.TempleFestival.DTO.summary.FestivalFinancialSummaryResponseDTO;
import com.example.TempleFestival.DTO.summary.FestivalInfoResponseDTO;
import com.example.TempleFestival.DTO.summary.FinancialSummaryResponseDTO;
import com.example.TempleFestival.DTO.summary.MaterialDonationResponseDTO;
import com.example.TempleFestival.DTO.summary.TransactionSummaryResponseDTO;
import com.example.TempleFestival.exception.ResourceNotFoundException;
import com.example.TempleFestival.model.Festival;
import com.example.TempleFestival.model.Payment;
import com.example.TempleFestival.model.Donation;
import com.example.TempleFestival.model.Expense;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service 
public class FestivalFinancialService {
    

    private final FestivalRepository festivalRepository;
    private final PaymentRepository paymentRepository;
    private final DonationRepository donationRepositry;
    private final ExpenseRepository expenseRepository;


    public FestivalFinancialService(FestivalRepository festivalRepository,
                                     PaymentRepository paymentRepository,
                                     DonationRepository donationRepository,
                                     ExpenseRepository expenseRepository){
                                   
    this.festivalRepository = festivalRepository;
    this.donationRepositry = donationRepository;
    this.paymentRepository = paymentRepository;
    this.expenseRepository = expenseRepository;

    }

    // FINAL FESTIVAL FINANCIAL SUMMARY

    public FestivalFinancialSummaryResponseDTO  getFestivalFinancialSummary(int festivalId){

       Festival festival =  festivalRepository.findById(festivalId).
         orElseThrow(() -> new ResourceNotFoundException("Festival not found with id: " + festivalId));

         List<Payment> payments = paymentRepository.findByFestivalFestivalId(festivalId);

         List<Donation> donations = donationRepositry.findByFestivalFestivalId(festivalId);

         List<Expense> expenses = expenseRepository.findByFestivalFestivalId(festivalId);

       double totalPayments = 0;

       for(Payment payment : payments){

        totalPayments = totalPayments + payment.getAmount();

       }
     
       double totalCashDonations = 0;

       for(Donation donation : donations){

        String donationType = donation.getItem().getDonationType().getDonationTypeName();

        if(donationType.equalsIgnoreCase("Money")){

            totalCashDonations = totalCashDonations + donation.getValue();

        }
       }

       double totalExpense = 0;

       for(Expense expense : expenses){

         totalExpense = totalExpense + expense.getExpenseTotalAmount();

       }
      
       double totalIncome = totalPayments + totalCashDonations;

       double balanceAmount = totalIncome - totalExpense;


       FestivalInfoResponseDTO festivalResponse = new FestivalInfoResponseDTO();

       festivalResponse.setFestivalId(festival.getFestivalId());
       festivalResponse.setFestivalName(festival.getFestivalName());
       festivalResponse.setFestivalYear(festival.getFestivalYear());


       FinancialSummaryResponseDTO financial = new FinancialSummaryResponseDTO();

       financial.setTotalPayments(totalPayments);
       financial.setTotalCashDonations(totalCashDonations);
       financial.setTotalIncome(totalIncome);
       financial.setTotalExpense(totalExpense);
       financial.setBalanceAmount(balanceAmount);


       Map<String, MaterialDonationResponseDTO> materialMap = new LinkedHashMap<>();

       for(Donation donation : donations){

        String donationType = donation.getItem().getDonationType().getDonationTypeName();

        if(!donationType.equalsIgnoreCase("Money")){

          String itemName = donation.getItem().getItemName();
            
          String unit = donation.getItem().getUnit().getUnitName();

          double quantity = donation.getValue();
 
            if(materialMap.containsKey(itemName)){

              MaterialDonationResponseDTO existing = materialMap.get(itemName);

              existing.setQuantity(existing.getQuantity() + quantity );

            }
            else{
              MaterialDonationResponseDTO material = new MaterialDonationResponseDTO();

             material.setItemName(itemName);
             material.setQuantity(quantity);
             material.setUnit(unit);

             materialMap.put(itemName,material);
              
            }
        
        }

       }

       DonationSummaryResponseDTO donationSummary = new DonationSummaryResponseDTO();

       donationSummary.setCashDonation(totalCashDonations);
       donationSummary.setMaterialDonations(materialMap);


        long totalMembers = paymentRepository.countMembersByFestivalId(festivalId);

           TransactionSummaryResponseDTO transactionSummary = new TransactionSummaryResponseDTO();

           transactionSummary.setTotalPaymentTransactions(payments.size());
           transactionSummary.setTotalDonationTransactions(donations.size());
           transactionSummary.setTotalExpenseTransactions(expenses.size());
           transactionSummary.setTotalMembers(totalMembers);
           
     FestivalFinancialSummaryResponseDTO response = new FestivalFinancialSummaryResponseDTO();

     response.setFestival(festivalResponse);
     response.setFinancialSummary(financial);
     response.setDonationSummary(donationSummary);
     response.setTransactionSummary(transactionSummary);

     return response;
    }
}
